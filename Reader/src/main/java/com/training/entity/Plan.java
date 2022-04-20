package com.training.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Plan {
	
	private int id;
	private int plan;
	public Plan(int plan) {
		super();
		this.plan = plan;
	}
	
	public Plan() {
		super();
	}

	
	

}
