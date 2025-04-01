package action;

import com.opensymphony.xwork2.ActionSupport;

import dbutil.HibernateUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pojo.MaintenanceRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MaintenanceRequestReportAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	private byte[] reportBytes;
    private InputStream reportStream;
    private String contentDisposition;

    public String execute() {
        try {
            // Load the report template
            InputStream reportTemplate = getClass().getResourceAsStream("/reports/maintenance_request_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);

            // Fetch data from database
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            List<MaintenanceRequest> maintenanceRequests = session.createQuery("FROM MaintenanceRequest", MaintenanceRequest.class).getResultList();
            session.close();

            // Create a data source
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(maintenanceRequests);

            // Fill the report
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export to PDF
            reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            reportStream = new ByteArrayInputStream(reportBytes);
            contentDisposition = "inline; filename=maintenance_request_report.pdf";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    // Getters for reportStream and contentDisposition
    public InputStream getReportStream() {
        return reportStream;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }
}