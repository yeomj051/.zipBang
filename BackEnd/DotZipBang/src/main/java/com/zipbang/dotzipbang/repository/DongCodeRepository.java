package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.DongCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DongCodeRepository extends JpaRepository<DongCode,Long> {

    @Query(value = "select dc from DongCode dc where substring(dc.dongCode,3,10) ='00000000'" )
    List<DongCode> getSidoList();

    @Query(value = "select dc from DongCode dc where substring(dc.dongCode,1,2) = :dongCode and substring(dc.dongCode,5,10)='000000' and substring(dc.dongCode,3,10) <> '00000000' ")
    List<DongCode> getGugunList(String dongCode);

    @Query(value = "select dc from DongCode dc where substring(dc.dongCode,1,4) = :dongCode and substring(dc.dongCode,5,10) <> '000000'")
    List<DongCode> getDongList(String dongCode);

    DongCode findByDongCode(String dongCode);
 }
