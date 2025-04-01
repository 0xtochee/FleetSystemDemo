package pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "LOGIN_INFO", schema = "vehicle_maintenance_demo")
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    
    public LoginInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	// Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
    
    
}