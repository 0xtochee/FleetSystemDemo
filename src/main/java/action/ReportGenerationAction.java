package action;

import com.opensymphony.xwork2.ActionSupport;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.servlet.http.HttpServletResponse; 
import org.apache.struts2.interceptor.ServletResponseAware; 
import java.io.OutputStream; 
import net.sf.jasperreports.engine.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportGenerationAction extends ActionSupport implements ServletResponseAware {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerationAction.class);
    
    private HttpServletResponse response;
    private HikariDataSource dataSource;

    public ReportGenerationAction() {
        // Configure the DataSource
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/vehicle_maintenance");
        config.setUsername("vehicle_app");
        config.setPassword("T3c#Crunc#");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response; // Set the response
    }
    
    public String generateReport() {
        try (Connection conn = dataSource.getConnection()) {
            // Compile Report
            JasperReport jasperReport = JasperCompileManager.compileReport("/Users/mac/Documents/VehicleMaintenanceDemoUno/src/main/resources/reports/MaintenanceRequestReport.jrxml");
            logger.info("Done compiling...");

            // Fill Report from DB (no parameters needed)
            JasperPrint jasperPrintMaster = JasperFillManager.fillReport(jasperReport, null, conn);
            logger.info("Done filling Jasper Report.");

            // Check if the report is filled with data
            if (jasperPrintMaster.getPages().isEmpty()) {
                logger.warn("No data found for the report.");
                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Set HTTP status for no content
                return ERROR; // Handle no data case
            }
            
            // Set response headers
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"MaintenanceRequestReport.pdf\"");
            
            // Write report to output stream
            try (OutputStream out = response.getOutputStream()) {
                JasperExportManager.exportReportToPdfStream(jasperPrintMaster, out);
                out.flush();
            }
            
            logger.info("Report generated successfully.");
            response.setStatus(HttpServletResponse.SC_OK); // Set HTTP status for success

            return SUCCESS; // Return success
        } catch (JRException e) {
            logger.error("JasperReports error: ", e);
            return ERROR; // Handle JasperReports specific error
        } catch (SQLException e) {
            logger.error("Database error: ", e);
            return ERROR; // Handle SQL specific error
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
            return ERROR; // Handle any other error
        }
    }
}













//package action;
//
//import com.opensymphony.xwork2.ActionSupport;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import javax.servlet.http.HttpServletResponse; 
//import org.apache.struts2.interceptor.ServletResponseAware; 
//import java.io.OutputStream; 
//import net.sf.jasperreports.engine.*;
//import java.sql.Connection;
//
//public class ReportGenerationAction extends ActionSupport implements ServletResponseAware{
//    private static final long serialVersionUID = 1L;
//    private HttpServletResponse response;
////    private String reportPath = "/Users/mac/Documents/VehicleMaintenanceDemoUno/src/main/resources/reports/MaintenanceRequestReport.jrxml";
////    private String outputPath = "/Users/mac/Documents/VehicleMaintenanceDemoUno/src/main/resources/reports/MaintenanceRequestsReport.pdf";
//    private HikariDataSource dataSource;
//
//    public ReportGenerationAction() {
//        // Configure the DataSource
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/vehicle_maintenance");
//        config.setUsername("vehicle_app");
//        config.setPassword("T3c#Crunc#");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        dataSource = new HikariDataSource(config);
//    }
//
//    @Override
//    public void setServletResponse(HttpServletResponse response) {
//        this.response = response; // Set the response
//    }
//    
//    public String generateReport() {
//        try (Connection conn = dataSource.getConnection()) {
//            // Compile Report
//            JasperReport jasperReport = JasperCompileManager.compileReport("/Users/mac/Documents/VehicleMaintenanceDemoUno/src/main/resources/reports/MaintenanceRequestReport.jrxml");
//            System.out.println("Done compiling... :-");
//
//            // Fill Report from DB (no parameters needed)
//            JasperPrint jasperPrintMaster = JasperFillManager.fillReport(jasperReport, null, conn);
//            System.out.println("Done filling Jasper Report.");
//
//            // Check if the report is filled with data
//            if (jasperPrintMaster.getPages().isEmpty()) {
//                System.out.println("No data found for the report.");
//                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Set HTTP status for no content
//                return ERROR; // Handle no data case
//            }
//            
//            // Set response headers
//            response.setContentType("application/pdf");
//            response.setHeader("Content-Disposition", "attachment; filename=\"MaintenanceRequestReport.pdf\"");
//            
//            // Write report to output stream
//            try (OutputStream out = response.getOutputStream()) {
//                JasperExportManager.exportReportToPdfStream(jasperPrintMaster, out);
//                out.flush();
//            }
//            
//            System.out.println("Report generated successfully.");
//            response.setStatus(HttpServletResponse.SC_OK); // Set HTTP status for success
//
////            // Export Report
////            JasperExportManager.exportReportToPdfFile(jasperPrintMaster, "/Users/mac/Documents/VehicleMaintenanceDemoUno/src/main/resources/reports/MaintenanceRequestsReport.pdf");
////            System.out.println("Done exporting the PDF report.");
//
//            return SUCCESS; // Return success
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ERROR; // Handle error appropriately
//        }
//    }
//}