package action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.WelcomeDAO;
import pojo.Client;
import pojo.Office;
import pojo.Personnel;
import pojo.VehicleCategory;
import pojo.VehicleGroup;

public class WelcomeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private List<Office> officeList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private List<VehicleCategory> vehicleCategoryList = new ArrayList<>();
    private List<VehicleGroup> vehicleGroupList = new ArrayList<>();
    private List<Personnel> personnelList = new ArrayList<>();
    private String selectedCategory;
    private List<VehicleGroup> filteredVehicleGroups;
    private InputStream reportStream;
    private String contentDisposition;
    private WelcomeDAO welcomeDAO;

    public WelcomeAction() {
        welcomeDAO = new WelcomeDAO();
    }

    public String execute() {
        System.out.println("WELCOME execute() method called");
        try {
            officeList = welcomeDAO.getOfficeListFromDB();
            System.out.println("Fetched " + officeList.size() + " offices");
            if (officeList.isEmpty()) {
                System.out.println("Warning: officeList is empty");
            } else {
                System.out.println("First office: " + officeList.get(0));
            }
            
            clientList = welcomeDAO.getClientListFromDB();
            System.out.println("Fetched " + clientList.size() + " clients");
            
            vehicleCategoryList = welcomeDAO.getVehicleCategoryListFromDB();
            System.out.println("Fetched " + vehicleCategoryList.size() + " vehicle categories");
            
            vehicleGroupList = welcomeDAO.getVehicleGroupListFromDB();
            System.out.println("Fetched " + vehicleGroupList.size() + " vehicle groups");
            
            personnelList = welcomeDAO.getPersonnelListFromDB();
            System.out.println("Fetched " + personnelList.size() + " personnel");
            
            logListContents();
            
            return SUCCESS;
        } catch (Exception e) {
            System.err.println("Error in WelcomeAction.execute(): " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        } finally {
            System.out.println("officeList size after execute: " + officeList.size());
        }
    }
    
    private void logListContents() {
        System.out.println("Logging office list contents:");
        for (Office office : officeList) {
            System.out.println("Office: " + office.getId() + " - " + office.getName());
        }
        System.out.println("Logging client list contents:");
        for (Client client : clientList) {
            System.out.println("Client: " + client.getId() + " - " + client.getName());
        }
        System.out.println("Logging personnel list contents:");
        for (Personnel personnel : personnelList) {
            System.out.println("Personnel: " + personnel.getId() + " - " + personnel.getName());
        }
        System.out.println("Logging vehicle Category list contents:");
        for (VehicleCategory vehicleCategory : vehicleCategoryList) {
            System.out.println("Vehicle Category: " + vehicleCategory.getId() + " - " + vehicleCategory.getName());
        }
        System.out.println("Logging vehicle Group list contents:");
        for (VehicleGroup vehicleGroup : vehicleGroupList) {
            System.out.println("Vehicle Category: " + vehicleGroup.getId() + " - " + vehicleGroup.getModel());
        }
    }
    
    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public List<VehicleGroup> getFilteredVehicleGroups() {
        return filteredVehicleGroups;
    }

    public String filterVehicleGroups() {
        System.out.println("filterVehicleGroups called with selectedCategory: " + selectedCategory);
        if (selectedCategory != null && !selectedCategory.isEmpty()) {
            filteredVehicleGroups = welcomeDAO.getVehicleGroupsByCategory(selectedCategory);
            System.out.println("Filtered vehicle groups: " + filteredVehicleGroups.size());
        } else {
            filteredVehicleGroups = new ArrayList<>();
        }
        return SUCCESS;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }
    
    public List<Client> getClientList() {
        return clientList;
    }
    
    public List<VehicleCategory> getVehicleCategoryList() {
        return vehicleCategoryList;
    }
    
    public List<VehicleGroup> getVehicleGroupList() {
        return vehicleGroupList;
    }
    
    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

	public InputStream getReportStream() {
		return reportStream;
	}

	public void setReportStream(InputStream reportStream) {
		this.reportStream = reportStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}
}


//package action;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//import dao.WelcomeDAO;
//import pojo.Client;
//import pojo.Office;
//import pojo.Personnel;
//import pojo.VehicleCategory;
//import pojo.VehicleGroup;
//
//public class WelcomeAction extends ActionSupport {
//    private static final long serialVersionUID = 1L;
//    private List<Office> officeList = new ArrayList<>();
//    private List<Client> clientList = new ArrayList<>();
//    private List<VehicleCategory> vehicleCategoryList = new ArrayList<>();
//    private List<VehicleGroup> vehicleGroupList = new ArrayList<>();
//    private List<Personnel> personnelList = new ArrayList<>();
//    private WelcomeDAO welcomeDAO;
//
//    public WelcomeAction() {
//        welcomeDAO = new WelcomeDAO();
//    }
//

//
//    // Getters remain the same
//}