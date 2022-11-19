package com.zipbang.dotzipbang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "house_Info")
public class HouseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="house_info_id")
    private Long id;

    private Long aptCode;
    private Long buildYear;
    private String roadName;
    private String roadNameBonbun;
    private String roadNameBubun;
    private String roadNameSeq;
    private String roadNameBasementCode;
    private String roadNameCode;
    private String dong;
    private String bonbun;
    private String bubun;
    private String sigunguCode;
    private String eubmyundongCode;
    private String dongCode;
    private String landCode;
    private String apartmentName;
    private String jibun;
    private String lng;
    private String lat;






}
