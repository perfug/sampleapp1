package com.octo.red.newsql.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer groupId;
	private String storeName;
	private String storeReference;
	// 4 figures and one letter
	// APE code is stricly french
	private String apeCode;
	private String legalForm;
	private String nVAT;
	private String rcs;
	private String managementCenterSuscriber;
	private String managementCenter1Reference;
	private String managementCenter2Reference;
	@OneToMany(mappedBy="store")
	private Set<Stock> stocks = new HashSet<Stock>();
	// TODO Transform these Strings into references
	private String mailServerReference;
	private String contactReference;
	private String generalParametersReference;
	private String dealerParametersReference;
	private String distributorParametersReference;

	public Long getId() {
		return id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreReference() {
		return storeReference;
	}

	public void setStoreReference(String storeReference) {
		this.storeReference = storeReference;
	}

	public String getApeCode() {
		return apeCode;
	}

	public void setApeCode(String apeCode) {
		this.apeCode = apeCode;
	}

	public String getLegalForm() {
		return legalForm;
	}

	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}

	public String getnVAT() {
		return nVAT;
	}

	public void setnVAT(String nVAT) {
		this.nVAT = nVAT;
	}

	public String getRcs() {
		return rcs;
	}

	public void setRcs(String rcs) {
		this.rcs = rcs;
	}

	public String getManagementCenterSuscriber() {
		return managementCenterSuscriber;
	}

	public void setManagementCenterSuscriber(String managementCenterSuscriber) {
		this.managementCenterSuscriber = managementCenterSuscriber;
	}

	public String getManagementCenter1Reference() {
		return managementCenter1Reference;
	}

	public void setManagementCenter1Reference(String managementCenter1Reference) {
		this.managementCenter1Reference = managementCenter1Reference;
	}

	public String getManagementCenter2Reference() {
		return managementCenter2Reference;
	}

	public void setManagementCenter2Reference(String managementCenter2Reference) {
		this.managementCenter2Reference = managementCenter2Reference;
	}

	/**
	 * No Setter, use rather addSock()
	 * @return
	 */
	public Set<Stock> getStocks() {
		return stocks;
	}
	
	public void addStock(Stock stock) {
		assert stock != null;
		stock.setStore(this);
		this.stocks.add(stock);
	}

	public String getMailServerReference() {
		return mailServerReference;
	}

	public void setMailServerReference(String mailServerReference) {
		this.mailServerReference = mailServerReference;
	}

	public String getContactReference() {
		return contactReference;
	}

	public void setContactReference(String contactReference) {
		this.contactReference = contactReference;
	}

	public String getGeneralParametersReference() {
		return generalParametersReference;
	}

	public void setGeneralParametersReference(String generalParametersReference) {
		this.generalParametersReference = generalParametersReference;
	}

	public String getDealerParametersReference() {
		return dealerParametersReference;
	}

	public void setDealerParametersReference(String dealerParametersReference) {
		this.dealerParametersReference = dealerParametersReference;
	}

	public String getDistributorParametersReference() {
		return distributorParametersReference;
	}

	public void setDistributorParametersReference(
			String distributorParametersReference) {
		this.distributorParametersReference = distributorParametersReference;
	}

}
