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

}
