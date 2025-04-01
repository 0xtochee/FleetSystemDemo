package action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pojo.MaintenanceRequest;
// import jakarta.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.apache.struts2.ServletActionContext;

public class ReportAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private List<MaintenanceRequest> requests; // This should be populated with your data
    private InputStream reportStream; // InputStream for the generated PDF report

    public String generateReport() {
        try {
            // Load the compiled Jasper report (.jasper file)
            InputStream reportFile = getClass().getClassLoader().getResourceAsStream("/reports/MaintenanceRequestsReport.jasper");
            if (reportFile == null) {
                System.out.println("Report file not found!");
                return ERROR;
            }

            // Load the Jasper report
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);

            // Create a data source from your list of MaintenanceRequest objects
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(requests);

            // Parameters to be passed to the report (if any)
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Maintenance Requests");

            // Fill the report with data and parameters
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Create a ByteArrayOutputStream to hold the generated PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            // Set the generated PDF content as InputStream for the action
            setReportStream(new ByteArrayInputStream(outputStream.toByteArray()));
            System.out.println("ReportStream is set: " + (reportStream != null));

            
         // Optionally, add the InputStream to the Servlet context
            // ServletActionContext.getRequest().setAttribute("reportStream", reportStream);

            return SUCCESS; // Return success to indicate the report was generated
        } catch (JRException e) {
            e.printStackTrace();
            return ERROR; // Handle error appropriately
        }
    }

    // Getter for reportStream (used by Struts to stream the PDF)
    public InputStream getReportStream() {
        return reportStream;
    }

    // Setter for reportStream
    public void setReportStream(InputStream reportStream) {
        this.reportStream = reportStream;
    }

    // Getter and setter for requests (your data source)
    public List<MaintenanceRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<MaintenanceRequest> requests) {
        this.requests = requests;
    }
}
