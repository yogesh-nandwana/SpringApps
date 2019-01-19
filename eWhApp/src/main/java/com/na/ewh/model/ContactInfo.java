package com.na.ewh.model;

import javax.persistence.*;

@Entity
public class ContactInfo {
	public ContactInfo() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(nullable=true,length=10)
	private String landlineNo;
	
	@Column(nullable=true,length=10)
	private String cellphoneNo;
	
	@Column(nullable=true,length=30)
	private String emailId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getCellphoneNo() {
		return cellphoneNo;
	}

	public void setCellphoneNo(String cellphoneNo) {
		this.cellphoneNo = cellphoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactInfo [id=");
		builder.append(id);
		builder.append(", landlineNo=");
		builder.append(landlineNo);
		builder.append(", cellphoneNo=");
		builder.append(cellphoneNo);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append("]");
		return builder.toString();
	}
}