package other.hht.bank;

public class BankList__c {
	
	private Long id;
	private String  bankCountryCode__c;
	private String  bankCode__c;
	private String  bankName__c;
	private Long  entityType;
	public String getBankCountryCode__c() {
		return bankCountryCode__c;
	}
	public void setBankCountryCode__c(String bankCountryCode__c) {
		this.bankCountryCode__c = bankCountryCode__c;
	}
	public String getBankCode__c() {
		return bankCode__c;
	}
	public void setBankCode__c(String bankCode__c) {
		this.bankCode__c = bankCode__c;
	}
	public String getBankName__c() {
		return bankName__c;
	}
	public void setBankName__c(String bankName__c) {
		this.bankName__c = bankName__c;
	}
	public Long getEntityType() {
		return entityType;
	}
	public void setEntityType(Long entityType) {
		this.entityType = entityType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
