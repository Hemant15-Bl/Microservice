package com.java.main.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
public class Rating {
	@Id
	@Column
	private String id;
	@Column
	private String employeeId;
	@Column
	private String hotelId;
	@Column
	private int rating;
	@Column
	private String feedback;
	@Transient
	private Hotel hotel;
}
