package com.example.bank_app.DataAccess.Models;

public class User
{

    private String document;
    private String eMail;
    private String password;
    private String role;

    public User()
    {

    }
    public User(int idUser, String eMail, String password, String role,String document) {
        this.eMail = eMail;
        this.password = password;
        this.role = role;
        this.document=document;
    }

    public User(String eMail, String password, String role,String document) {
        this.eMail = eMail;
        this.password = password;
        this.role = role;
        this.document=document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String geteMail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "document='" + document + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
