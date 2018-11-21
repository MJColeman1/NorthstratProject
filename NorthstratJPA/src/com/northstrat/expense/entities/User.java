package com.northstrat.expense.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	//start of fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private boolean admin;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Profile profile;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Expense> expenses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Travel> travel;
	
	//end of fields
	
	//start of constructors
	
	public User() {
		
	}

	public User(int id, String username, String password, boolean admin, Profile profile, List<Expense> expenses,
			List<Travel> travel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.profile = profile;
		this.expenses = expenses;
		this.travel = travel;
	}
	
	//end of constructors

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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Travel> getTravel() {
		return travel;
	}

	public void setTravel(List<Travel> travel) {
		this.travel = travel;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", admin=" + admin
				+ ", profile=" + profile + ", expenses=" + expenses + ", travel=" + travel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((travel == null) ? 0 : travel.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (admin != other.admin)
			return false;
		if (expenses == null) {
			if (other.expenses != null)
				return false;
		} else if (!expenses.equals(other.expenses))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (travel == null) {
			if (other.travel != null)
				return false;
		} else if (!travel.equals(other.travel))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
