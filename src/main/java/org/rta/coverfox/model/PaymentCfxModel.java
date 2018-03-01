/**
 * 
 */
package org.rta.coverfox.model;

/**
 * @author arun.verma
 *
 */
public class PaymentCfxModel {
    private String transactionId;
    private String paymentId;
    private String paymentToken;
    private String status;
    private String dateTime;
    private String amount;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentCfxModel [transactionId=" + transactionId + ", paymentId=" + paymentId + ", paymentToken="
                + paymentToken + ", status=" + status + ", dateTime=" + dateTime + ", amount=" + amount + "]";
    }

}
