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

@Transactional
@RestController
@RequestMapping("/jasper")
public class JasperCtl {

    @PersistenceContext
    private EntityManager entityManager;

    private SessionFactory sessionFactory;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public void generateReport(HttpServletResponse response) {

        System.out.println("******** Jasper Report Start ********");

        Connection con = null;

        try {
            // ✅ Docker-safe JRXML loading
            InputStream input = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("reports/Deepak.jrxml");

            if (input == null) {
                throw new RuntimeException("❌ JRXML file not found in resources/reports");
            }

            // ✅ Compile report
            JasperReport jasperReport = JasperCompileManager.compileReport(input);

            // ✅ Parameters
            Map<String, Object> params = new HashMap<>();
            params.put("createdBy", "Admin");

            // ✅ DB Connection
            sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

            con = sessionFactory.getSessionFactoryOptions()
                    .getServiceRegistry()
                    .getService(ConnectionProvider.class)
                    .getConnection();

            // ✅ Fill report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

            // ✅ Export to PDF
            byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

            // ✅ Response headers (VERY IMPORTANT)
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=marksheet.pdf");
            response.setContentLength(pdf.length);

            // ✅ Write PDF
            response.getOutputStream().write(pdf);
            response.getOutputStream().flush();
            response.getOutputStream().close();

            System.out.println("✅ Jasper Report Generated Successfully");

        } catch (Exception e) {
            e.printStackTrace();

            try {
                response.setContentType("text/plain");
                response.getWriter().write("Error generating PDF: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } finally {
            // ✅ Close connection
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
