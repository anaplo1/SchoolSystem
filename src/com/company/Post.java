package com.company;

public enum Post {
    TEACHER("Teacher"), ADMIN("Admin"), HEADMASTER("Headmaster"), STUDENT("Student");

    private final String post;

    Post(String str){this.post = str;}

    public String getPost(){
        return post;
    }
}
