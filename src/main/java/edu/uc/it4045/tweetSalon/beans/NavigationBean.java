package edu.uc.it4045.tweetSalon.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationBean implements Serializable{
    public String moveToIndex() {
        return "index";
    }

    public String moveToUser() {
        return "user";

    }
}
