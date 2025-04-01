package action;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.MaintenanceRequest;
import dbutil.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistoryAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
	private List<MaintenanceRequest> requests;
	private List<String> officeList;
    private List<String> clientList;
    private List<String> personnelList;
    private List<String> vehicleList;
    private List<String> workshopList;
    private List<String> statusList;
    public String execute() {
        System.out.println("HistoryAction execute method called");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            requests = session.createQuery("FROM MaintenanceRequest", MaintenanceRequest.class).getResultList();
            
            // Fetch office names using the IDs
            List<Integer> officeIds = session.createQuery("SELECT DISTINCT office FROM MaintenanceRequest WHERE office IS NOT NULL", Integer.class).list();
            // Fetch office names using the IDs
            if (!officeIds.isEmpty()) {
                setOfficeList(session.createQuery("SELECT o.name FROM Office o WHERE o.id IN :ids", String.class)
                    .setParameterList("ids", officeIds)
                    .list());
            } else {
                setOfficeList(new ArrayList<>());
            }
            
            // Fetch client names using IDs
            List<Integer> clientIds = session.createQuery("SELECT DISTINCT client FROM MaintenanceRequest WHERE client IS NOT NULL", Integer.class).list();
            // Fetch office names using the IDs
            if (!clientIds.isEmpty()) {
            	setClientList(session.createQuery("SELECT c.name FROM Client c WHERE c.id IN :ids", String.class)
                    .setParameterList("ids", clientIds)
                    .list());
            } else {
                setClientList(new ArrayList<>());
            }

            
            // Fetch vehicleGroup names using IDs
            List<Integer> vehicleGroupIds = session.createQuery("SELECT DISTINCT vehicle FROM MaintenanceRequest WHERE vehicle IS NOT NULL", Integer.class).list();
            // Fetch vehicleGroup names using the IDs
            if (!vehicleGroupIds.isEmpty()) {
            	setVehicleList(session.createQuery("SELECT v.model FROM VehicleGroup v WHERE v.id IN :ids", String.class)
                    .setParameterList("ids", vehicleGroupIds)
                    .list());
            } else {
            	setVehicleList(new ArrayList<>());
            }
            
            // Fetch personnel IDs from MaintenanceRequest
            List<Integer> personnelIds = session.createQuery("SELECT DISTINCT personnel FROM MaintenanceRequest WHERE personnel IS NOT NULL", Integer.class).list();
            
            // Fetch personnel names using the IDs
            if (!personnelIds.isEmpty()) {
                setPersonnelList(session.createQuery("SELECT p.name FROM Personnel p WHERE p.id IN :ids", String.class)
                    .setParameterList("ids", personnelIds)
                    .list());
            } else {
                setPersonnelList(new ArrayList<>());
            }
            
            // Set names in MaintenanceRequest objects
            for (MaintenanceRequest request : requests) {
                request.setOfficeName(getOfficeNameById(session, request.getOffice()));
                request.setClientName(getClientNameById(session, request.getClient()));
                request.setVehicleName(getVehicleNameById(session, request.getVehicle()));
                request.setWorkshopName(getWorkshopNameById(request.getWorkshop()));
            }
            
            // Example usage of workshopList
            workshopList = new ArrayList<>(); // Initialize if needed
            workshopList.add("Workshop A"); // Add example data
            
            System.out.println("Number of requests retrieved: " + (requests != null ? requests.size() : "null"));
            System.out.println("Offices: " + officeList);
            System.out.println("Clients: " + clientList);
            System.out.println("Personnel: " + personnelList);
            
            if (requests != null && !requests.isEmpty()) {
                System.out.println("First request: " + requests.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error retrieving maintenance requests: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    private String getWorkshopNameById(String workshop) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getOfficeNameById(Session session, Integer officeId) {
        return session.createQuery("SELECT o.name FROM Office o WHERE o.id = :id", String.class)
                      .setParameter("id", officeId)
                      .uniqueResult();
    }

    private String getClientNameById(Session session, Integer clientId) {
        return session.createQuery("SELECT c.name FROM Client c WHERE c.id = :id", String.class)
                      .setParameter("id", clientId)
                      .uniqueResult();
    }

    private String getVehicleNameById(Session session, Integer vehicleId) {
        return session.createQuery("SELECT v.model FROM VehicleGroup v WHERE v.id = :id", String.class)
                      .setParameter("id", vehicleId)
                      .uniqueResult();
    }

	// Getter and setter for requests
    public List<MaintenanceRequest> getRequests() {
        return requests;
    }

	public void setRequests(List<MaintenanceRequest> requests) {
		this.requests = requests;
	}

	public List<String> getOfficeList() {
		return officeList;
	}

	public void setOfficeList(List<String> officeList) {
		this.officeList = officeList;
	}

	public List<String> getClientList() {
		return clientList;
	}

	public void setClientList(List<String> clientList) {
		this.clientList = clientList;
	}

	public List<String> getPersonnelList() {
		return personnelList;
	}

	public void setPersonnelList(List<String> personnelList) {
		this.personnelList = personnelList;
	}
	
	public List<String> getStatusList() {
	    return Arrays.asList("Submitted", "Queried", "Scheduled", "Approved", "Completed", "Closed", "Cancelled");
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public List<String> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public List<String> getWorkshopList() {
		return Arrays.asList("Along", "Ikoyi", "VI", "Opebi", "Ikeja", "Apapa", "Yaba");
	}

	public void setWorkshopList(List<String> workshopList) {
		this.workshopList = workshopList;
	}
}


