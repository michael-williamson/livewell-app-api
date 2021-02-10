package com.app.livewell_app_api.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fish")
public class Fish {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
    @Column(name="species")
    private String species;
    @Column(name="inches")
    private Long inches;
    @Column(name="pounds")
    private Long pounds;
    @Column(name="ounces")
	private Long ounces;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user; 
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public Long getInches() {
		return inches;
	}
	public void setInches(Long inches) {
		this.inches = inches;
	}
	public Long getPounds() {
		return pounds;
	}
	public void setPounds(Long pounds) {
		this.pounds = pounds;
	}
	public Long getOunces() {
		return ounces;
	}
	public void setOunces(Long ounces) {
		this.ounces = ounces;
	}
	@Override
	public String toString() {
		return "Fish [id=" + id + ", inches=" + inches + ", ounces=" + ounces + ", pounds=" + pounds + ", species="
				+ species + "]";
	} 

    
}
