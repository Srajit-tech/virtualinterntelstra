package au.com.telstra.simcardactivator.domain;

public class actuatorresponse {
    private boolean success;

    public actuatorresponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
