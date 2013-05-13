package com.octo.red.newsql.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	private String alpha3Code;

	private Integer numericCode;
	private String countryName;
	@OneToMany(mappedBy="country")
	private Set<VAT> vatList;

	/**
	 * Required for JPA even if fields are accessed by reflection
	 */
	public Country() {}
	
	public Country(String alpha3Code, Integer numericCode, String countryName,
			Set<VAT> vatList) {
		super();
		this.alpha3Code = alpha3Code;
		this.numericCode = numericCode;
		this.countryName = countryName;
		this.vatList = vatList;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public Integer getNumericCode() {
		return numericCode;
	}

	public void setNumericCode(Integer numericCode) {
		this.numericCode = numericCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * No set, use rather addVat()
	 * @return
	 */
	public Set<VAT> getVatList() {
		return vatList;
	}

	public void addVat(VAT vat) {
		assert vat != null;
		vat.setCountry(this);
		this.vatList.add(vat);
	}

}
