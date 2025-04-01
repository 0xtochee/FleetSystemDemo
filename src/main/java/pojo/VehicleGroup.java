package pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_group")
public class VehicleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "name")
    private VehicleCategory category;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "make")
    private String make;
    
    @Column(name = "status")
    private String status;

    public VehicleGroup() {

    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VehicleCategory getCategory() {
		return category;
	}

	public void setCategory(VehicleCategory category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "VehicleGroup [id=" + id + ", category=" + category + ", model=" + model + ", make=" + make + ", status="
				+ status + "]";
	}
}