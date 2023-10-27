package com.synrgy.binarfud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Entity // menandakan bahwa class ini adalah sebuah table
@Table(name = "users") // namnya user
public class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.UUID) // auto uuid
    private UUID id;

    private String username;

    @Column(name = "email_address")
    private String emailAddress;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orderList;
}
