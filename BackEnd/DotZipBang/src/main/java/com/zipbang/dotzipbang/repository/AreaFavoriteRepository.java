package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.AreaFavorite;
import com.zipbang.dotzipbang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaFavoriteRepository extends JpaRepository<AreaFavorite,Long> {
    List<AreaFavorite> findByUser(User user);
}
