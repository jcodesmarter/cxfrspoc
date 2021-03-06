package poc.raviraj.cxfrspoc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import poc.raviraj.cxfrspoc.custom.CustomDateDeserializer;
import poc.raviraj.cxfrspoc.custom.CustomDateSerializer;

@Entity
@Table(name = "poc_users")
@SQLDelete(sql = "UPDATE poc_users SET deleteFlag = 1 WHERE userId = ? AND version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleteFlag='0'")
public class User extends AuditableModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotEmpty(message = "First Name cannot be blank")
	@Pattern(regexp = "[a-zA-Z]+", message = "First Name contains invalid characters")
	private String firstName;

	@NotEmpty(message = "Last Name cannot be blank")
	@Pattern(regexp = "[a-zA-Z]+", message = "Last Name contains invalid characters")
	private String lastName;

	@Valid
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "genderId")
	private Gender gender;

	@JsonSerialize(using = CustomDateSerializer.class)	
	@JsonDeserialize(using = CustomDateDeserializer.class)	
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@NotEmpty(message = "Username cannot be blank")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Username contains invalid characters")
	@Size(min = 6, max = 15, message = "Username length must be between 6 to 15 characters")
	private String userName;

	private String password = "Hello135";

	@Valid
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId")
	private Department department;

	@Valid
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designationId")
	private Designation designation;

	@Valid
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Role role;

	public User() {
		// required for generating proxy.. proxy is generated by the gwt
		// compiler
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
