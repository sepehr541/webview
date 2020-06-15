package com.webview.webview.model;
import java.util.List;

public class UserWithWebsites {

    private String id;

    private String email;

    private String password;

    private List<Website> websites;

    public UserWithWebsites() {
    }

    public UserWithWebsites(String email, String password, List<Website> websites) {
        this.email = email;
        this.password = password;
        this.websites = websites;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "UserWithWebsites{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", websites=" + websites +
                '}';
    }
}
