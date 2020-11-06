package other.hht.bank;

public class test {

	public static void main(String[] args) {
        String sql = "select BankCountryCode__c, BankCode__c, BankName__c, from bankList__c where bankCode__c = '"+1+"' AND bankCountryCode__c = '"+2+"'";

        System.out.println(sql);
        
	}
}
