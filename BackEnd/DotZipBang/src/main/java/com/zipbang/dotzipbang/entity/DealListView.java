package com.zipbang.dotzipbang.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Subselect("SELECT hd.deal_year, hd.deal_month, hi.dong_code, concat(hd.deal_year, '.', hd.deal_month,'.',hd.deal_day) deal_date, hd.deal_day, hi.apartment_name, hd.deal_amount, hd.area, hi.lat, hi.lng\n" +
        "FROM house_deal hd join house_info hi on hd.apt_code = hi.apt_code")
@Data
@NoArgsConstructor
@Table(name = "deal_list_view")

public class DealListView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
