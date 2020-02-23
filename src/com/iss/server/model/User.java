package com.iss.server.model;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    public  void User(){
        setUserId(null);
        setUserName(null);
        setPassword(null);
    }

    @Override//重写equals方法，hashCode不会重写
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o instanceof  User){
            User user = (User)o;
            return userId == user.getUserId() && userName.equals(user.getUserName()) && password.equals(user.getPassword());
        }

        return false;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
