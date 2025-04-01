package pojo;


import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "credit_type")
    private String creditType;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "contact")
    private String contact;
    
    @Column(name = "last_activity_date")
    private LocalDateTime lastActivityDate;


    public Client() {
    }
    
    
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCreditType() {
		return creditType;
	}


	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public LocalDateTime getLastActivityDate() {
		return lastActivityDate;
	}


	public void setLastActivityDate(LocalDateTime lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", type=" + type + ", email=" + email + ", name=" + name + ", code=" + code
				+ ", phone=" + phone + ", creditType=" + creditType + ", address=" + address + ", status=" + status
				+ ", contact=" + contact + ", lastActivityDate=" + lastActivityDate + "]";
	}
}