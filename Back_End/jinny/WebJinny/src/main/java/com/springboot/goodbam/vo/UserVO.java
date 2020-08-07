package com.springboot.goodbam.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserVO {
    private String userID ;
    private String userPass ;
    private String userName;
    private String userEmail ;
    private String userQue ;
    private String userAns;
    private Date userSignupdate;
    private int userNum;
}
