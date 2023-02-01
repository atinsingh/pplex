package com.example.pragraplex.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
    private String phone;
    @Column(unique = true)
    private String login;
    private String passWord;
    @Transient
    private boolean isLoggedIn;
    private Date createDate;
    private Date updateDate;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
