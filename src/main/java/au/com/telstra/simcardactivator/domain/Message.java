package au.com.telstra.simcardactivator.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private String iccid;
    private String email;

    public Message(String iccid, String email) {
        this.iccid = iccid;
        this.email = email;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Message{" +
                "iccid='" + iccid + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
