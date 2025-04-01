package pojo;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "maintenance_requests")
public class MaintenanceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_date")
    private Date requestDate;
    
    @Column(name = "office")
    private Integer office;

    @Column(name = "client")
    private Integer client;
    
    @Column(name = "vehicle")
    private Integer vehicle;
    
    @Column(name = "fault_type")
    private String faultType;
    
    @Column(name = "personnel")
    private Integer personnel;
    
    @Column(name = "status")
    private String status;

    @Column(name = "vehicle_mileage")
    private Integer vehicleMileage;

    @Column(name = "workshop")
    private String workshop;

    @Column(name = "complaints")
    private String complaints;
    
    @Transient // This tells Hibernate not to map this field to the database
    private String officeName;
    @Transient
    private String clientName;
    @Transient
    private String vehicleName;
    @Transient
    private String workshopName;

 // Getters and setters for each field
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Integer getOffice() {
		return office;
	}

	public void setOffice(Integer office) {
		this.office = office;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public Integer getVehicle() {
		return vehicle;
	}

	public void setVehicle(Integer vehicle) {
		this.vehicle = vehicle;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public Integer getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Integer personnel) {
		this.personnel = personnel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVehicleMileage() {
		return vehicleMileage;
	}

	public void setVehicleMileage(Integer vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String string) {
		this.workshop = string;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	
	public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

	@Override
	public String toString() {
		return "MaintenanceRequest [id=" + id + ", requestDate=" + requestDate + ", office=" + office + ", client="
				+ client + ", vehicle=" + vehicle + ", faultType=" + faultType + ", personnel=" + personnel
				+ ", status=" + status + ", vehicleMileage=" + vehicleMileage + ", workshop=" + workshop
				+ ", complaints=" + complaints + ", officeName=" + officeName + ", clientName=" + clientName
				+ ", vehicleName=" + vehicleName + ", workshopName=" + workshopName + "]";
	}

	
}


	
	