package com.cts.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Country {
	@Id
	private int id;
	private String name;
	private float population;
	private int states;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPopulation() {
		return population;
	}
	public void setPopulation(float population) {
		this.population = population;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Country(int id, String name, float population, int states, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.states = states;
		this.date = date;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", population=" + population + ", states=" + states + ", date="
				+ date + "]";
	}
	
	

}
