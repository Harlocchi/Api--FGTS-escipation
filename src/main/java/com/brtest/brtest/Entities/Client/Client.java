package com.brtest.brtest.Entities.Client;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String LastName;
    private String phone;

    @Column(unique = true)
    private String mail;

    private String password;




}
