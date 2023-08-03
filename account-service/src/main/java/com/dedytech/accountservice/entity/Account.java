package com.dedytech.accountservice.entity;

import lombok.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "uname")
    private String username;

    @Setter
    @Column(value = "name")
    private String name;

    @Setter
    @Column(value = "surname")
    private String surname;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "pwd")
    private String password;

    @Setter
    @Column(value = "number")
    private String phoneNumber;

    @Setter
    @Column(value = "balance")
    private String currentBalance;

    @Setter
    @Column(value = "dob")
    private String dob;

    @Setter
    @Column(value = "adresse1")
    private String address1;

    @Setter
    @Column(value = "adresse2")
    private String address2;

    @Setter
    @Column(value = "ville")
    private String city;

    @Setter
    @Column(value = "codepostale")
    private String zip;

    @Setter
    @Column(value = "pays")
    private String country;

    @Column(value = "create_at")
    private Date createAt;

    @Column(value = "is_active")
    private Boolean active;
}