package com.rays.ctl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.*;

/**
 * JasperCtl is a REST controller used for generating Jasper Reports in PDF
 * format.
 * 
 * It loads JRXML file, compiles it, fills data using database connection, and
 * returns the generated PDF as HTTP response.
 * 
 * All endpoints are mapped under "/jasper".
 * 
 * @author Deepak Verma
 */
@Transactional
@RestController
@RequestMapping("/jasper")
public class JasperCtl {

	/**
	 * EntityManager for database access
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Hibernate SessionFactory
	 */
	private SessionFactory sessionFactory;

	/**
	 * Generates Jasper report and returns PDF response
	 * 
	 * @param response HttpServletResponse object
	 * @throws JRException  Jasper exception
	 * @throws IOException  IO exception
	 * @throws SQLException SQL exception
	 */
	@GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
	public void generateReport(HttpServletResponse response) throws JRException, IOException, SQLException {

		System.out.println("******** Jasper Report Start ********");

		Connection con = null;

		try {
			// Load JRXML file from resources
			InputStream input = getClass().getResourceAsStream("/reports/Deepak.jrxml");

			if (input == null) {
				throw new RuntimeException("JRXML file not found in resources/reports");
			}

			// Compile JRXML to JasperReport
			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Set parameters for report
			Map<String, Object> params = new HashMap<>();
			params.put("createdBy", "Admin");

			// Get DB connection from Hibernate
			sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

			con = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class)
					.getConnection();

			// Fill report with data
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

			// Export report to PDF
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			// Set response headers
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=marksheet.pdf");

			// Write PDF to response
			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();

			System.out.println("******** Report Generated ********");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close DB connection
			if (con != null) {
				con.close();
			}
		}
	}
}