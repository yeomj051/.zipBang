package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.HouseFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseFavoriteRepository extends JpaRepository<HouseFavorite,Long> {
}
