/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.ieti.data.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Andr�sQuintero
 */
public class User {
    
    @Id
    private String id;

    private String name;

    private String email;
    
    public User(String id,String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format("User[id=%s, Name='%s', Email='%s']",
                id, name, email);
    }
    
}
