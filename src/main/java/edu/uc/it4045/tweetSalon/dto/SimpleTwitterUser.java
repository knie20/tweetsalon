package edu.uc.it4045.tweetSalon.dto;

public class SimpleTwitterUser implements ITwitterUser{
    private String userId;
    private String handle;

    public SimpleTwitterUser() {
    }

    public SimpleTwitterUser(String userId, String handle) {
        this.userId = userId;
        this.handle = handle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
