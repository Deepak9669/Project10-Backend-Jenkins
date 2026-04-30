package com.rays.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;
import com.rays.service.UserServiceInt;

/**
 * JWTRequestFilter class for handling JWT-based authentication.
 * 
 * This filter intercepts every HTTP request and performs:
 * 
 * - Extraction of JWT token from Authorization header - Validation of token -
 * Authentication setup in Spring Security context - Setting UserContext for
 * current request
 * 
 * It ensures that only authenticated users can access secured APIs.
 * 
 * @author Deepak Verma
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	@Autowired
	private UserServiceInt userService;

	/**
	 * Filters incoming requests and validates JWT token.
	 * 
	 * @param request     HTTP request
	 * @param response    HTTP response
	 * @param filterChain filter chain
	 * @throws ServletException exception
	 * @throws IOException      exception
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			String jwtToken = authorizationHeader.substring(7);

			try {

				String loginId = jwtUtil.extractLoginId(jwtToken);

				if (!jwtUtil.validateToken(jwtToken, loginId)) {
					throw new Exception("Invalid JWT token");
				}

				   if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					   
	                    String role = jwtUtil.extractRole(jwtToken);
	                    
	                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	                            loginId, null,
	                            List.of(new SimpleGrantedAuthority("ROLE_" + role))
	                    );
	                    
	                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                    
	                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	                }

	                UserDTO dto = new UserDTO();
	                dto.setLoginId(loginId);
	                dto.setId(jwtUtil.extractUserId(jwtToken)); 
	                System.out.println("request filter: " + dto.getLoginId());
	                UserContext context = new UserContext(dto);
	                UserContextHolder.setContext(context);
	            } catch (Exception e) {
	                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	                response.setContentType("application/json");
	                response.getWriter().write(e.getMessage());
	                return;
	            }
	        } 
	        filterChain.doFilter(request, response);
	    }
	}
