package thirdpartytest.model;

import java.io.Serializable;

public class OnPremRequest implements Serializable {

    private String sessionId;
    private String pdeId;
    private String phoneNumber;

    public OnPremRequest() {
    }

    public OnPremRequest(String sessionId, String pdeId, String phoneNumber) {
        this.sessionId = sessionId;
        this.pdeId = pdeId;
        this.phoneNumber = phoneNumber;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPdeId() {
        return pdeId;
    }

    public void setPdeId(String pdeId) {
        this.pdeId = pdeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "OnPremRequest{" +
                "sessionId='" + sessionId + '\'' +
                ", pdeId='" + pdeId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
