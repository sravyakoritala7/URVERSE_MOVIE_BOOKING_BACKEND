package com.urverse.admin;
public class AdminDetails {
    private String uname,password;
    public AdminDetails(){}
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
