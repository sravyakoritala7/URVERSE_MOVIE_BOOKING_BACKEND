package com.urverse.newuser;
public class NewUserDetails {
    private String uname,password;
    public NewUserDetails(){}
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
