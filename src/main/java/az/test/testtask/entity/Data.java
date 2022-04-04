package az.test.testtask.entity;

import az.test.testtask.dto.UserDataRequest;

import java.util.Objects;

public class Data {

    private Long userId;
    private Long levelId;
    private Integer result;

    public Data() {
    }

    public Long getUserId() {
        return userId;
    }

    public Data setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getLevelId() {
        return levelId;
    }

    public Data setLevelId(Long levelId) {
        this.levelId = levelId;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public Data setResult(Integer result) {
        this.result = result;
        return this;
    }

    public static Data mapper(UserDataRequest request) {
        return new Data()
                .setUserId(request.getUserId())
                .setLevelId(request.getLevelId())
                .setResult(request.getResult());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(userId, data.userId) &&
                Objects.equals(levelId, data.levelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, levelId);
    }

    @Override
    public String toString() {
        return "Data{" +
                "userId=" + userId +
                ", levelId=" + levelId +
                ", result=" + result +
                '}';
    }
}
