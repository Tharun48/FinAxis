package com.finaxis.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Entity
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private long accountNumber;

    @NotNull(message = "username should be specified")
    @Size(min=3,max=25)
    private String name;

    private String email;

    @NotNull(message = "age cannot be null")
    private Integer age;

    private String address;

    private long cardNumber;
}
