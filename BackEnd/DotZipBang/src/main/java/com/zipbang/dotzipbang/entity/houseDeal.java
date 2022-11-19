package com.zipbang.dotzipbang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "house_deal")
public class houseDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="house_deal_id")
    private Long id;

    private Long no;
    private String dealAmount;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String area;
    private String floor;
    private String cancelDealType;
    private String aptCode;


}
