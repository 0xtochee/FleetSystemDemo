package pojo;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "office")
    private Office office;
    @ManyToOne
    @JoinColumn(name = "vehicle_category")
    private VehicleCategory vehicleCategory;
    @ManyToOne
    @JoinColumn(name = "vehicle_group")
    private VehicleGroup vehicleGroup;
    @ManyToOne
    @JoinColumn(name = "personnel")
    private Personnel personnel;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
    @Column(name = "fault_type")
    private String faultType;
    @Column(name = "date")
    private Date date;
    @Column(name = "mileage")
    private String mileage;
    @Column(name = "location")
    private String location;
    @Column(name = "complaints")
    private String complaints;
    @Column(name = "status")
    private String status;
    
//    @ManyToOne
//    @JoinColumn(name = "file")
//    private FileUpload fileUpload;
    
	@Override
	public String toString() {
		return "Request [id=" + id + ", office=" + office + ", driver=" + personnel + ", client=" + client + ", faultType="
				+ faultType + ", date=" + date + ", mileage=" + mileage + ", location=" + location + ", complaint="
				+ complaints + ", status=" + status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public VehicleGroup getVehicleGroup() {
		return vehicleGroup;
	}

	public void setVehicleGroup(VehicleGroup vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}