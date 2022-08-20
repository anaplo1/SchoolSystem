package com.company;

public class User {
    private String username;
    private String password;

    private String mark;
    private int userID;
    private Post post;

    public User(String username, String password, Post post){
        this.username = username;
        this.password = password;
        this.userID = (int) (Math.random() * 100);
        this.post = post;
        //System.out.print(this.post);
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setMark(String mark){
        this.mark = mark;
    }

    public String getMark(){
        return this.mark;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getPost() {
        return post.getPost();
    }

    public String getUsername() {
        return username;
    }
}
