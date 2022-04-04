package az.test.testtask.utils;


public class LogDetail {

    private String requestKey;
    private String requestPath;
    private String ip;

    public LogDetail() {
    }

    public String getRequestKey() {
        return this.requestKey;
    }

    public String getRequestPath() {
        return this.requestPath;
    }

    public String getIp() {
        return this.ip;
    }

    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public String toString() {
        return "LogDetail(requestKey=" + this.getRequestKey() + ", requestPath=" + this.getRequestPath() + ", ip=" + this.getIp() + ")";
    }
}
