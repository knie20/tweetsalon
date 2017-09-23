package edu.uc.it4045.tweetSalon.beans;

import edu.uc.it4045.tweetSalon.dto.SimpleTwitterUser;
import edu.uc.it4045.tweetSalon.service.IUserService;
import edu.uc.it4045.tweetSalon.service.UserService;
import org.json.JSONException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.FileNotFoundException;
import java.io.Serializable;

@ManagedBean(name = "searchUserBean", eager = false)
@RequestScoped
public class SearchUserBean implements Serializable {
    @ManagedProperty(value = "#{param.handle}")
    private String handle;
    private SimpleTwitterUser user;

    public SearchUserBean() {
    }

    public void searchUser() throws FileNotFoundException, JSONException {
        IUserService userService = new UserService();
        SimpleTwitterUser user = null;
        this.user = userService.getUserFromDBByHandle(handle);
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) { this.handle = handle; }

    public SimpleTwitterUser getUser() {
        return user;
    }

    public void setUser(SimpleTwitterUser user) {
        this.user = user;
    }
}
