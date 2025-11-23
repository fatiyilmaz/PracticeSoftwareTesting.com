package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDetails {
    private BankDetails paymentBankDetails;

    public PaymentDetails(BankDetails paymentBankDetails) {
        this.paymentBankDetails = paymentBankDetails;
    }

    public BankDetails getPaymentBankDetails() {
        return paymentBankDetails;
    }

    public void setPaymentBankDetails(BankDetails paymentBankDetails) {
        this.paymentBankDetails = paymentBankDetails;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentBankDetails=" + paymentBankDetails +
                '}';
    }
}
