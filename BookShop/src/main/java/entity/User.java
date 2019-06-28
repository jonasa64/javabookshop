/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Jonas
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int blance;

    public User() {
    }
    
    

    public User(int id, String username, int blance) {
        this.id = id;
        this.username = username;
        this.blance = blance;
    }

    public User(String username, String password, int blance) {
        this.username = username;
        this.password = password;
        this.blance = blance;
    }

    public int getId() {
        return id;
    }

  

  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", blance=" + blance + '}';
    }


    
    
    
    
    
}
