package pojo;

public class RequestForm {
    private String office;
    private String personnel;
    private String faultType;
    private String client;
    private String complaints;
    private String workshop;
    private String location;
    private Integer vehicleMileage;
    private String vehicleGroup;
    private String vehicleCategory;
    
    public RequestForm() {
    	// empty constructor stub
    }

	public RequestForm(String office, String personnel, String faultType, String client, String complaints,
			String workshop, String location, Integer vehicleMileage, String vehicleGroup, String vehicleCategory) {
		super();
		this.office = office;
		this.personnel = personnel;
		this.faultType = faultType;
		this.client = client;
		this.complaints = complaints;
		this.workshop = workshop;
		this.location = location;
		this.vehicleMileage = vehicleMileage;
		this.vehicleGroup = vehicleGroup;
		this.vehicleCategory = vehicleCategory;
	}

	// getters and setters
	public String getOffice() {
		return office;
	}
	
	public void setOffice(String office) {
		this.office = office;
	}
	
	public String getPersonnel() {
		return personnel;
	}
	
	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}
	
	public String getFaultType() {
		return faultType;
	}
	
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getVehicleMileage() {
		return vehicleMileage;
	}

	public void setMileage(Integer vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}

	public String getVehicleGroup() {
		return vehicleGroup;
	}

	public void setVehicleGroup(String vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	@Override
	public String toString() {
		return "RequestForm [office=" + office + ", personnel=" + personnel + ", faultType=" + faultType + ", client="
				+ client + ", complaints=" + complaints + ", workshop=" + workshop + ", location=" + location
				+ ", mileage=" + vehicleMileage + ", vehicleGroup=" + vehicleGroup + ", vehicleCategory=" + vehicleCategory
				+ "]";
	}
    
}


