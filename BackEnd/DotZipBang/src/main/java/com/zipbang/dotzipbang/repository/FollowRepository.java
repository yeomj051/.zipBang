package com.zipbang.dotzipbang.repository;

import com.zipbang.dotzipbang.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {
}
