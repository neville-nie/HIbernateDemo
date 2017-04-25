package entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

	// Fields

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;

	@Column(name = "user_name", length = 50)
	private String userName;

	@Column(name = "user_email", length = 50)
	private String userEmail;

	@Version
	@Column(name = "version")
	private Integer version;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userEmail) {
		this.userName = userName;
		this.userEmail = userEmail;
	}

	// Property accessors
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", version="
				+ version + "]";
	}

}