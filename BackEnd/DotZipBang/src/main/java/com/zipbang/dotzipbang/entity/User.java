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
    private String userid;
    private String email;
    private String password;
    private String name;
    private String phone;

    private String address;
    private String introduce;
    private String gender;
    private String img_address;
    private String authority;

    private String token;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", introduce='" + introduce + '\'' +
                ", gender='" + gender + '\'' +
                ", img_address='" + img_address + '\'' +
                ", authority='" + authority + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
