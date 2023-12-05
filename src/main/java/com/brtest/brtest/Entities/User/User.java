package com.brtest.brtest.Entities.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String firstName;
    private String  LastName;

    private String phone;

    private String cpf;

    @Column(unique = true)
    private String mail;

    private String password;

    private TypeUser typeUser;






}
