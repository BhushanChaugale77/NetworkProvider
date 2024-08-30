package com.prowings.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class NetworkDto {

	private Integer id;
	@NonNull
	@NotEmpty
	@NotBlank
	private String networkProviderName;
	@NonNull
	private  Double networkPlans;
	
	@Pattern(
	        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
	        message = "Invalid email address"
	    )
	private String providerEmail;
	@NonNull
	@NotEmpty
	@NotBlank
	private String providerWebsite;

	public NetworkDto() {
		super();
		// TODO Auto-generated constructor stub
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
		return "NetworkDto [id=" + id + ", networkProviderName=" + networkProviderName + ", networkPlans="
				+ networkPlans + ", providerEmail=" + providerEmail + ", providerWebsite=" + providerWebsite + "]";
	}
	
	
	
}
