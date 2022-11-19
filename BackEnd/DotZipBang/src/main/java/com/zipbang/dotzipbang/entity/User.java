package com.zipbang.dotzipbang.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "user")
public class User extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private String phone;

    private String address;
    private String introduce;
    private String gender;
    private String img_address;
    private String authority;







}
