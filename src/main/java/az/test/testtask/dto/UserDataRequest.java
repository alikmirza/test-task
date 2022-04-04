package az.test.testtask.dto;

public class UserDataRequest {

    private Long userId;
    private Long levelId;
    private Integer result;


    public Long getUserId() {
        return userId;
    }

    public UserDataRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getLevelId() {
        return levelId;
    }

    public UserDataRequest setLevelId(Long levelId) {
        this.levelId = levelId;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public UserDataRequest setResult(Integer result) {
        this.result = result;
        return this;
    }
}
