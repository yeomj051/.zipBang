package com.zipbang.dotzipbang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "dong_code")
public class DongCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dong_code_id")
    private Long id;

    private String dongCode;
    private String sidoName;
    private String gugunName;
    private String dongName;

}
