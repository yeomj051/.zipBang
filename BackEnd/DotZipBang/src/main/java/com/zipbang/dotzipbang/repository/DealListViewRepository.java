package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.DealListView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealListViewRepository extends JpaRepository<DealListView,Long> {

    @Query(value = "select dl from DealListView dl where dl.dealYear =:year and dl.dealMonth=:month and dl.dongCode =:dongCode and dl.apartmentName like concat('%', :apartment, '%')")
    List<DealListView> findByApart(String year,String month, String apartment,String dongCode);
}
