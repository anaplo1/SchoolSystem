package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class SystemController {

    protected ArrayList<User> users = new ArrayList<>();

    private int size = 0;

    public void reg(User user){
        boolean f = true;
        for (User id: users){
            if (Objects.equals(id.getUsername(), user.getUsername())) {
                System.out.println("Данный пользователь уже зарегестрирован!");
                f = false;
                break;
            }
        }
        if (f){this.users.add(user); size++;}
    }

    public int getSize(){return size;}


    public boolean eraseUser(User user){
        for (User id: users) {
            if (Objects.equals(id.getUsername(), user.getUsername())) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }
    public void printReg(){
        for (User id: users){
            System.out.println(id.getUsername() + " " + id.getPassword());
        }
    }
}
