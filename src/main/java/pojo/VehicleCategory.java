package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_category")
@Getter
@Setter
@NoArgsConstructor
public class VehicleCategory {
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<VehicleGroup> vehicleGroups;
    
    public VehicleCategory() {

    }
    
    
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<VehicleGroup> getVehicleGroups() {
        return vehicleGroups;
    }

    public void setVehicleGroups(List<VehicleGroup> vehicleGroups) {
        this.vehicleGroups = vehicleGroups;
    }

	@Override
	public String toString() {
		return "VehicleCategory [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
}