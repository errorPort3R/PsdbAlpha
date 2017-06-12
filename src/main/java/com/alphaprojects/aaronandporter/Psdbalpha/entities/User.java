package com.alphaprojects.aaronandporter.Psdbalpha.entities;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by jeffryporter on 6/8/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Address address;

    private String facebookId;

    @Column(nullable = false)
    private HashMap<Integer, Boolean> pollingAnswers;

    public User()
    {
    }

    public User(String username, String password, Address address, String facebookId, HashMap<Integer, Boolean> pollingAnswers)
    {
        this.username = username;
        this.password = password;
        this.address = address;
        this.facebookId = facebookId;
        this.pollingAnswers = pollingAnswers;
    }

    public User(int id, String username, String password, Address address, String facebookId, HashMap<Integer, Boolean> pollingAnswers)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.facebookId = facebookId;
        this.pollingAnswers = pollingAnswers;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getFacebookId()
    {
        return facebookId;
    }

    public void setFacebookId(String facebookId)
    {
        this.facebookId = facebookId;
    }

    public HashMap<Integer, Boolean> getPollingAnswers()
    {
        return pollingAnswers;
    }

    public void setPollingAnswers(HashMap<Integer, Boolean> pollingAnswers)
    {
        this.pollingAnswers = pollingAnswers;
    }
}
