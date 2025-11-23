package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankDetails {
    private String bank_name;
    private String account_name;
    private Integer account_number;

    public BankDetails(String bank_name, String account_name, Integer account_number) {
        this.bank_name = bank_name;
        this.account_name = account_name;
        this.account_number = account_number;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Integer getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Integer account_number) {
        this.account_number = account_number;
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "bank_name='" + bank_name + '\'' +
                ", account_name='" + account_name + '\'' +
                ", account_number=" + account_number +
                '}';
    }
}
