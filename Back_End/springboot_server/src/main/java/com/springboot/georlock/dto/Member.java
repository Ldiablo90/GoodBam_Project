package com.springboot.georlock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
       private String userID ;
       private String userPass ;
       private String userName;
       private String userQue ;
       private String userAns ;

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
}
