package edu.uc.it4045.tweetSalon.beans;

import edu.uc.it4045.tweetSalon.service.IUserService;
import edu.uc.it4045.tweetSalon.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "searchUserBean", eager = false)
public class SearchUserBean {
    @ManagedProperty(value = "#{param.handle}")
    private String handle;

    public SearchUserBean() {
    }

    public String searchUser(){
        IUserService userService = new UserService();
        return "user_main";
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
