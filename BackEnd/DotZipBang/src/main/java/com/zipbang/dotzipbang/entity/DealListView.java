package com.zipbang.dotzipbang.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Data
@NoArgsConstructor

public class DealListView {
    @Id
    @Column(name = "deal_list_view_id")
    private Long id;

    private String dealYear;
    private String dealMonth;
    private String dongCode;
    private String dealDate;
    private String dealDay;

    private String apartmentName;
    private String dealAmount;
    private String area;
    private String lat;
    private String lng;
    private String buildYear;
    private String floor;


}
