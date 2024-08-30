package com.prowings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Network {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String networkProviderName;
	
	private  Double networkPlans;
	
	private String providerEmail;
	
	private String providerWebsite;

	public Network() {
		super();
 	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNetworkProviderName() {
		return networkProviderName;
	}

	public void setNetworkProviderName(String networkProviderName) {
		this.networkProviderName = networkProviderName;
	}

	public Double getNetworkPlans() {
		return networkPlans;
	}

	public void setNetworkPlans(Double networkPlans) {
		this.networkPlans = networkPlans;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderWebsite() {
		return providerWebsite;
	}

	public void setProviderWebsite(String providerWebsite) {
		this.providerWebsite = providerWebsite;
	}

	@Override
	public String toString() {
		return "Network [id=" + id + ", networkProviderName=" + networkProviderName + ", networkPlans=" + networkPlans
				+ ", providerEmail=" + providerEmail + ", providerWebsite=" + providerWebsite + "]";
	} 
}
