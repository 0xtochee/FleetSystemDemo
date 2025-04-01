package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
@Getter
@Setter
@NoArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "staff_no")
    private String staffNo;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "client")
    private String client;
    
    @Column(name = "workshop")
    private String workshop;
    
    @Column(name = "office")
    private String office;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "verification_code")
    private String verificationCode;



    public Personnel() {

    }
    
    
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStaffNo() {
		return staffNo;
	}


	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getWorkshop() {
		return workshop;
	}


	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}


	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getVerificationCode() {
		return verificationCode;
	}


	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}


	@Override
	public String toString() {
		return "Personnel [id=" + id + ", staffNo=" + staffNo + ", name=" + name + ", phone=" + phone + ", type=" + type
				+ ", email=" + email + ", client=" + client + ", workshop=" + workshop + ", office=" + office
				+ ", status=" + status + ", verificationCode=" + verificationCode + "]";
	}

    
}