package au.com.telstra.simcardactivator.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class actuatorrequest {
    private String iccid;

    public actuatorrequest(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}