package action;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import dbutil.HibernateUtil;
import pojo.MaintenanceRequest;
import pojo.RequestForm;

public class RequestAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	private RequestForm requestForm;
    private MaintenanceRequest maintenanceRequest;

    public String execute() {
    	
    	if (requestForm == null) {
            // This is likely a direct access to the action without form submission
            addActionError("Invalid request. Please submit the form properly.");
            return ERROR;
        }
    	
        try {
            // Convert RequestForm to MaintenanceRequest
        	MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        	if (requestForm.getOffice() != null && !requestForm.getOffice().isEmpty()) {
                try {
                    maintenanceRequest.setOffice(Integer.parseInt(requestForm.getOffice()));
                } catch (NumberFormatException e) {
                    addActionError("Invalid personnel ID");
                    return INPUT;
                }
            } else {
                maintenanceRequest.setOffice(null);
            }
        	
            if (requestForm.getPersonnel() != null && !requestForm.getPersonnel().isEmpty()) {
                try {
                    maintenanceRequest.setPersonnel(Integer.parseInt(requestForm.getPersonnel()));
                } catch (NumberFormatException e) {
                    addActionError("Invalid personnel ID");
                    return INPUT;
                }
            } else {
                maintenanceRequest.setPersonnel(null);
            }
            
            maintenanceRequest.setFaultType(requestForm.getFaultType());
            
            if (requestForm.getClient() != null && !requestForm.getClient().isEmpty()) {
                try {
                    maintenanceRequest.setClient(Integer.parseInt(requestForm.getClient()));
                } catch (NumberFormatException e) {
                    addActionError("Invalid personnel ID");
                    return INPUT;
                }
            } else {
                maintenanceRequest.setClient(null);
            }
            
            maintenanceRequest.setComplaints(requestForm.getComplaints());
            
            maintenanceRequest.setWorkshop(requestForm.getWorkshop());
            
            maintenanceRequest.setVehicleMileage(requestForm.getVehicleMileage());
            
            if (requestForm.getVehicleGroup() != null && !requestForm.getVehicleGroup().isEmpty()) {
                try {
                    maintenanceRequest.setVehicle(Integer.parseInt(requestForm.getVehicleGroup()));
                } catch (NumberFormatException e) {
                    addActionError("Invalid personnel ID");
                    return INPUT;
                }
            } else {
                maintenanceRequest.setVehicle(null);
            }
            
            maintenanceRequest.setStatus("Submitted");
            maintenanceRequest.setRequestDate(new Date());

            // Save to database
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.persist(maintenanceRequest); // Changed from save to persist
                tx.commit();
                System.out.println("Saved maintenance request: " + maintenanceRequest);
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error saving maintenance request: " + e.getMessage());
            return ERROR;
        }
    }
    
    // Getters and setters
	public RequestForm getRequestForm() {
		return requestForm;
	}

	public void setRequestForm(RequestForm requestForm) {
		this.requestForm = requestForm;
	}

	public MaintenanceRequest getMaintenanceRequest() {
		return maintenanceRequest;
	}

	public void setMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	} 
}










