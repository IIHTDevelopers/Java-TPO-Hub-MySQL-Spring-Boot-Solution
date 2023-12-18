package com.tpohubapplication.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanyDTO {

	private Long id;

	@NotBlank
	private String companyName;

	@NotBlank
	private String stream;

	@NotBlank
	private String minimumQualification;

	private Double minimumPassingPercentage;

	@NotBlank
	private String mustToHave;

	@NotBlank
	private String goodToHave;

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Long id, @NotBlank String companyName, @NotBlank String stream,
			@NotBlank String minimumQualification, Double minimumPassingPercentage,
			@NotBlank String mustToHave, @NotBlank String goodToHave) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.stream = stream;
		this.minimumQualification = minimumQualification;
		this.minimumPassingPercentage = minimumPassingPercentage;
		this.mustToHave = mustToHave;
		this.goodToHave = goodToHave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getMinimumQualification() {
		return minimumQualification;
	}

	public void setMinimumQualification(String minimumQualification) {
		this.minimumQualification = minimumQualification;
	}

	public Double getMinimumPassingPercentage() {
		return minimumPassingPercentage;
	}

	public void setMinimumPassingPercentage(Double minimumPassingPercentage) {
		this.minimumPassingPercentage = minimumPassingPercentage;
	}

	public String getMustToHave() {
		return mustToHave;
	}

	public void setMustToHave(String mustToHave) {
		this.mustToHave = mustToHave;
	}

	public String getGoodToHave() {
		return goodToHave;
	}

	public void setGoodToHave(String goodToHave) {
		this.goodToHave = goodToHave;
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", companyName=" + companyName + ", stream=" + stream
				+ ", minimumQualification=" + minimumQualification + ", minimumPassingPercentage="
				+ minimumPassingPercentage + ", mustToHave=" + mustToHave + ", goodToHave=" + goodToHave + "]";
	}
}