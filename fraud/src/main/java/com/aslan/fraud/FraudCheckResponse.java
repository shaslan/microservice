package com.aslan.fraud;

public class FraudCheckResponse {

    private boolean isFraudster;

    public FraudCheckResponse(boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
    public FraudCheckResponse() {
    }

    public boolean isFraudster() {
        return isFraudster;
    }

    @Override
    public String toString() {
        return "FraudCheckResponse{" +
                "isFraudster=" + isFraudster +
                '}';
    }
}
