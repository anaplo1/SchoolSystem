package com.company;

import java.util.Objects;
import java.util.Scanner;

public class LoginSystemController extends SystemController{

    private User user;

    private boolean adminStatus = false;
    Scanner field = new Scanner(System.in);
    public LoginSystemController(User user){
        this.user = user;
    }

    public void logCheck(User user){
        for (User id: users){
            if (id.getUserID() == user.getUserID() && Objects.equals(id.getPassword(), user.getPassword())) {
                this.user = user;
                System.out.println("Вы успешно вошли в систему как "
                        + user.getUserID()+ " с должностью "+ user.getPost());
                if (!Objects.equals(user.getPost(), Post.STUDENT.getPost())){
                    this.adminStatus = true;
                }
                return;
            }
        }
        System.out.println("Неверные данные пользователя!");
    }

    public void deleteUser(User user) {
        if (!adminStatus){
            if (this.user.getUserID() == user.getUserID()){
                for (User id : users) {
                    if (id.getUserID() == user.getUserID() && Objects.equals(id.getPassword(), user.getPassword())) {
                        eraseUser(user);
                        return;
                    }
                }
            }
            else {
                System.out.println("Не являясь админом, можно удалять только свой профиль!");
            }
        } else {
            for (User id : users) {
                if (id.getUserID() == user.getUserID() && Objects.equals(id.getPassword(), user.getPassword())) {
                    eraseUser(user);
                    return;
                }
            }
        }
    }

    public void addUser(User user){
        if (!adminStatus){return;}
        users.add(user);
    }

    public void correctUser(User user){

        int choice = 0;
        if (!adminStatus){
            if (this.user.getUserID() == user.getUserID()){
                for (User id : users) {
                    if (id.getUserID() == user.getUserID()) {
                        System.out.println("Выберите какие данные хотите изменить: " +
                                "\n1. Поменять логин пользователя\n2. Поменять пароль пользователя");
                        choice = field.nextInt();
                        if (choice == 1) {
                            id.setUsername(field.nextLine());
                            return;
                        } else if (choice == 2) {
                            id.setPassword(field.nextLine());
                            return;
                        } else {
                            System.out.println("Данные ведены неверно!");
                            return;
                        }
                    }
                }
            }
            else {
                System.out.println("Не являясь админом, можно менять только свой профиль!");
                return;
            }
        } else {
            for (User id : users) {
                if (id.getUserID() == user.getUserID()) {
                    System.out.println("Выберите какие данные хотите изменить: " +
                            "\n1. Поменять логин пользователя\n2. Поменять пароль пользователя");
                    choice = field.nextInt();
                    if (choice == 1) {
                        id.setUsername(field.nextLine());
                        return;
                    } else if (choice == 2) {
                        id.setPassword(field.nextLine());
                        return;
                    } else {
                        System.out.println("Данные ведены неверно!");
                        return;
                    }
                }
            }
        }
    }

    public void setMark(User user){
        if (!adminStatus){return;}
        for (User id : users){
            if (id.getUserID() == user.getUserID()){
                id.setMark(field.nextLine());
            }
        }
    }

    public void getMark(User user){
        if (!adminStatus){return;}
        for (User id : users){
            if (id.getUserID() == user.getUserID()){
                System.out.println(id.getMark());
            }
        }
    }
}
