package poc.raviraj.cxfrspoc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AuditableModel extends VersionableModel {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "createdBy", updatable = false)
	private User createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdDate;
	@OneToOne
	@JoinColumn(name = "modifiedBy")
	private User modifiedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public AuditableModel() {
		// required for generating proxy.. proxy is generated by the gwt
		// compiler
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	// @Override
	// public String toString() {
	// return ToStringBuilder.reflectionToString(this,
	// ToStringStyle.DEFAULT_STYLE);
	// }

}
