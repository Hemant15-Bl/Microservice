package com.java.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Hotel {
	@Id
	@Column
	private String id;
	@Column
	private String name;
	@Column
	private String location;
	@Column
	private String about;
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getLocation() {
//		return location;
//	}
//	public void setLocation(String location) {
//		this.location = location;
//	}
//	public String getAbout() {
//		return about;
//	}
//	public void setAbout(String about) {
//		this.about = about;
//	}
//	public Hotel(String id, String name, String location, String about) {
//		this.id = id;
//		this.name = name;
//		this.location = location;
//		this.about = about;
//	}
//	public Hotel() {
//		// TODO Auto-generated constructor stub
//	}
	
	
}
