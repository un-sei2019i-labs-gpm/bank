package com.example.bank_app.DataAccess.Models;

public class User
{
    private int idUser;
    private String document;
    private String eMail;
    private String password;
    private String role;

    public User(int idUser, String eMail, String password, String role,String document) {
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
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
}
