package com.springboot.goodbam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component("userVO")
public class UserVO {
    private String userID ;
    private String userPass ;
    private String userName;
    private String userEmail ;
    private String userQue ;
    private String userAns;
    private String userSignupdate;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserQue() {
        return userQue;
    }

    public void setUserQue(String userQue) {
        this.userQue = userQue;
    }

    public String getUserAns() {
        return userAns;
    }

    public void setUserAns(String userAns) {
        this.userAns = userAns;
    }

    public String getUserSignupdate() {
        return userSignupdate;
    }

    public void setUserSignupdate(String userSignupdate) {
        this.userSignupdate = userSignupdate;
    }

}
