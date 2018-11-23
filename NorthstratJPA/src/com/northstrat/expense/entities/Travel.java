package com.northstrat.expense.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Travel {

	//start of fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "project_charge_code")
	private String projectChargeCode;
	
	@Column(name = "trip_location")
	private String tripLocation;
	
	@Column(name = "travel_dates")
	private String travelDates;
	
	
	@Column(name = "created_at")
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	private String status;
	
	@Column(name = "total_cost")
	private double totalCost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	//end of fields
	
	//start of constructors
	
	public Travel() {
		
	}

	public Travel(int id, String projectChargeCode, String tripLocation, String travelDates, Date createdAt,
			Date updatedAt, String status, double totalCost, User user) {
		super();
		this.id = id;
		this.projectChargeCode = projectChargeCode;
		this.tripLocation = tripLocation;
		this.travelDates = travelDates;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.totalCost = totalCost;
		this.user = user;
	}

	//end of constructors
	
	public String getProjectChargeCode() {
		return projectChargeCode;
	}

	public void setProjectChargeCode(String projectChargeCode) {
		this.projectChargeCode = projectChargeCode;
	}

	public String getTripLocation() {
		return tripLocation;
	}

	public void setTripLocation(String tripLocation) {
		this.tripLocation = tripLocation;
	}

	public String getTravelDates() {
		return travelDates;
	}

	public void setTravelDates(String travelDates) {
		this.travelDates = travelDates;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", projectChargeCode=" + projectChargeCode + ", tripLocation=" + tripLocation
				+ ", travelDates=" + travelDates + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status="
				+ status + ", totalCost=" + totalCost + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((projectChargeCode == null) ? 0 : projectChargeCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((travelDates == null) ? 0 : travelDates.hashCode());
		result = prime * result + ((tripLocation == null) ? 0 : tripLocation.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (projectChargeCode == null) {
			if (other.projectChargeCode != null)
				return false;
		} else if (!projectChargeCode.equals(other.projectChargeCode))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(totalCost) != Double.doubleToLongBits(other.totalCost))
			return false;
		if (travelDates == null) {
			if (other.travelDates != null)
				return false;
		} else if (!travelDates.equals(other.travelDates))
			return false;
		if (tripLocation == null) {
			if (other.tripLocation != null)
				return false;
		} else if (!tripLocation.equals(other.tripLocation))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
