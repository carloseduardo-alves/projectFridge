package com.projectFridge.projectFridge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Food {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int quantity;
	private int expirationDate;
	
	public Food() {}
	
	public Food(String name, int quantity, int expirationDate) {
		this.name = name;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }

	public int getExpirationDate() { return expirationDate; }
	public void setExpirationDate(int expirationDate) { this.expirationDate = expirationDate; }
}
