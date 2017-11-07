package edu.uc.it4045.tweetSalon.beans;

import edu.uc.it4045.tweetSalon.dao.TweetDAO;
import edu.uc.it4045.tweetSalon.dto.Tweet;
import edu.uc.it4045.tweetSalon.dto.TwitterUser;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "searchUserBean", eager = false)
@RequestScoped
public class SearchUserBean implements Serializable {
    @ManagedProperty(value = "#{param.handle}")
    private String handle;

    public SearchUserBean() {}

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

}
