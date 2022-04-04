package az.test.testtask.dto;

import az.test.testtask.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class ErrorInfo {

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date time;
    private String description;
    private Integer errorCode;
    private String url;
    private String trace;
    private String message;
    private String messageAz;
    private String messageRu;


    public ErrorInfo(Date time, String description, Integer errorCode, String url, String trace, String message, String messageAz, String messageRu) {
        this.time = time;
        this.description = description;
        this.errorCode = errorCode;
        this.url = url;
        this.trace = trace;
        this.message = message;
        this.messageAz = messageAz;
        this.messageRu = messageRu;
    }

    public ErrorInfo() {
    }

    public static ErrorInfoBuilder builder() {
        return new ErrorInfoBuilder();
    }

    public Date getTime() {
        return this.time;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTrace() {
        return this.trace;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageAz() {
        return this.messageAz;
    }

    public String getMessageRu() {
        return this.messageRu;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageAz(String messageAz) {
        this.messageAz = messageAz;
    }

    public void setMessageRu(String messageRu) {
        this.messageRu = messageRu;
    }

    public String toString() {
        return "ErrorInfo(time=" + this.getTime() + ", description=" + this.getDescription() + ", errorCode=" + this.getErrorCode() + ", url=" + this.getUrl() + ", trace=" + this.getTrace() + ", message=" + this.getMessage() + ", messageAz=" + this.getMessageAz() + ", messageRu=" + this.getMessageRu() + ")";
    }

    public static class ErrorInfoBuilder {
        private Date time;
        private String description;
        private Integer errorCode;
        private String url;
        private String trace;
        private String message;
        private String messageAz;
        private String messageRu;

        ErrorInfoBuilder() {
        }

        public ErrorInfoBuilder time(Date time) {
            this.time = time;
            return this;
        }

        public ErrorInfoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ErrorInfoBuilder errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorInfoBuilder url(String url) {
            this.url = url;
            return this;
        }

        public ErrorInfoBuilder trace(String trace) {
            this.trace = trace;
            return this;
        }

        public ErrorInfoBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorInfoBuilder messageAz(String messageAz) {
            this.messageAz = messageAz;
            return this;
        }

        public ErrorInfoBuilder messageRu(String messageRu) {
            this.messageRu = messageRu;
            return this;
        }

        public ErrorInfo build() {
            return new ErrorInfo(time, description, errorCode, url, trace, message, messageAz, messageRu);
        }

        public String toString() {
            return "ErrorInfo.ErrorInfoBuilder(time=" + this.time + ", description=" + this.description + ", errorCode=" + this.errorCode + ", url=" + this.url + ", trace=" + this.trace + ", message=" + this.message + ", messageAz=" + this.messageAz + ", messageRu=" + this.messageRu + ")";
        }
    }
}