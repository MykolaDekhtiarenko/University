package com.mdekhtiarenko.universitysignin.spring.viewBean;

import com.mdekhtiarenko.universitysignin.entity.User;
import org.springframework.context.annotation.Scope;

/**
 * Created by mykola.dekhtiarenko on 06.12.16.
 */
@Scope("session")
public class SignInBean {
    private User user;
    private String responce;
    private String type;

    public void setResponce(String responce) {
        this.responce = responce;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResponce() {
        return responce;
    }

    public String getType() {
        return type;
    }
}
