package com.letsstartcoding.springbootrestapiexample.Entity;

import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="Employees")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	
	
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
	
		private String name;
		
		
		private String designation;
		
		
		private String expertise;
		
		
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date createdAt;
		

		public Employee() {
			super();
		}

		public Employee(Long id, String name, String designation, String expertise, Date createdAt) {
			super();
			this.id = id;
			this.name = name;
			this.designation = designation;
			this.expertise = expertise;
			this.createdAt = createdAt;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getExpertise() {
			return expertise;
		}

		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", expertise=" + expertise
					+ ", createdAt=" + createdAt + "]";
		}

	}

