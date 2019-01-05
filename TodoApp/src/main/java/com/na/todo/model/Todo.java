package com.na.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo implements Comparable<Todo>{

	@Id
	@Column(name = "SRNO")
	private int srNo;

	@Column(name = "TEXT",unique=true)
	private String text;

	@Column(name="IS_COMPLETED")
	private char completed;

	@Column(name= "COMPLETION_DATE")
	private Date cDate;


	protected Todo(){
		//Not to be used directly
	} //needed to fix Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException: Could not read document

	public Todo(int srNo,String text) {
		this.srNo = srNo;
		this.text=text;
		this.completed = 'N'; 
	}

	public int getSrNo() {
		return srNo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public char getCompleted() {
		return completed;
	}

	public void setCompleted(char completed) {
		this.completed = completed;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	
	@Override
	public int compareTo(Todo o) {
		Integer currentSrNo = this.srNo;
		return currentSrNo.compareTo(o.getSrNo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cDate == null) ? 0 : cDate.hashCode());
		result = prime * result + completed;
		result = prime * result + srNo;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Todo))
			return false;
		Todo other = (Todo) obj;
		if (cDate == null) {
			if (other.cDate != null)
				return false;
		} else if (!cDate.equals(other.cDate))
			return false;
		if (completed != other.completed)
			return false;
		if (srNo != other.srNo)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Todo [srNo=%s, text=%s, completed=%s, cDate=%s]",
				srNo, text, completed, cDate);
	}
	
}