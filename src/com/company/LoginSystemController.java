package com.company;

import java.util.Objects;

public class LoginSystemController extends SystemController{

    private User user;

    private boolean adminStatus = false;

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
        if (!adminStatus){return;}
        for (User id : users) {
            if (id.getUserID() == user.getUserID() && Objects.equals(id.getPassword(), user.getPassword())) {
                eraseUser(user);
                return;
            }
        }
    }
}
