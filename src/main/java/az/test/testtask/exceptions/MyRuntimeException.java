package az.test.testtask.exceptions;

public class MyRuntimeException extends RuntimeException {

    private Integer status;
    private String messageEn;
    private String messageAz;
    private String messageRu;

    public MyRuntimeException(Integer status, String messageEn, String messageAz, String messageRu) {
        this.status = status;
        this.messageEn = messageEn;
        this.messageAz = messageAz;
        this.messageRu = messageRu;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.messageEn;
    }

    public String getMessageAz() {
        return this.messageAz;
    }

    public String getMessageRu() {
        return this.messageRu;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }

    public void setMessageAz(String messageAz) {
        this.messageAz = messageAz;
    }

    public void setMessageRu(String messageRu) {
        this.messageRu = messageRu;
    }

    public String toString() {
        return "MyRuntimeException(status=" + this.getStatus() + ", message=" + this.getMessage() + ", messageAz=" + this.getMessageAz() + ", messageRu=" + this.getMessageRu() + ")";
    }
}