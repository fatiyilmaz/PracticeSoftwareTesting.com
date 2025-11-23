package request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethod {
    private PaymentDetails paymentBankDetailsMethod;

    public PaymentMethod(PaymentDetails paymentBankDetailsMethod) {
        this.paymentBankDetailsMethod = paymentBankDetailsMethod;
    }

    public PaymentDetails getPaymentBankDetailsMethod() {
        return paymentBankDetailsMethod;
    }

    public void setPaymentBankDetailsMethod(PaymentDetails paymentBankDetailsMethod) {
        this.paymentBankDetailsMethod = paymentBankDetailsMethod;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentBankDetailsMethod=" + paymentBankDetailsMethod +
                '}';
    }
}
