
package com.urverse.user;
public class UserDetails {
    private String uname,password;
    public UserDetails(){}
    public void setuname(String uname){
        this.uname=uname;
    }
    public String getuname(){
        return this.uname;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public String getpassword(){
        return this.password;
    }
    
}
