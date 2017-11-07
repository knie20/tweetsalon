package edu.uc.it4045.tweetSalon.beans;

import edu.uc.it4045.tweetSalon.dto.ITwitterUser;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;
import edu.uc.it4045.tweetSalon.service.TwitterUserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "showUserBean", eager = false)
@RequestScoped
public class ShowUserBean {
    @ManagedProperty(value = "#{searchUserBean}")
    private SearchUserBean searchUser;

    private ITwitterUser user;

    public ShowUserBean() {
        TwitterUserService userService = new TwitterUserService();
        user = userService.getUserByHandle("KaidongNie");
        System.out.println(user);
    }

    public SearchUserBean getsearchUser() {
        return searchUser;
    }

    public void setsearchUser(SearchUserBean lookup) {
        this.searchUser = lookup;
    }
}
