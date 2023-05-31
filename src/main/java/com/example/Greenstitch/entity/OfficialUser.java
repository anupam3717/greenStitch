package com.example.Greenstitch.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user1")
public class OfficialUser {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String userName;


    @Column(nullable = false)
    private String password;

}
