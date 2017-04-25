package entityXml;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer stId;

	private String stName;

	private String stEmail;

	private Integer version;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String stName, String stEmail) {
		this.stName = stName;
		this.stEmail = stEmail;
	}

	// Property accessors
	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStEmail() {
		return this.stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Student [stId=" + stId + ", stName=" + stName + ", stEmail=" + stEmail + ", version=" + version + "]";
	}

}