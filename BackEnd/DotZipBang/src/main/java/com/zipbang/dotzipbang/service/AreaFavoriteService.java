package com.zipbang.dotzipbang.service;

import com.zipbang.dotzipbang.entity.AreaFavorite;
import com.zipbang.dotzipbang.entity.DongCode;
import com.zipbang.dotzipbang.entity.User;
import com.zipbang.dotzipbang.repository.AreaFavoriteRepository;
import com.zipbang.dotzipbang.repository.DongCodeRepository;
import com.zipbang.dotzipbang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AreaFavoriteService {

    private final AreaFavoriteRepository areaFavoriteRepository;
    private final UserRepository userRepository;
    private final DongCodeRepository dongCodeRepository;

    @Transactional
    public AreaFavorite save(String email, String dongCode) {
        User user1 = userRepository.findByEmail(email);
        DongCode dongCode1 = dongCodeRepository.findByDongCode(dongCode);
        AreaFavorite areaFavorite = new AreaFavorite();
        areaFavorite.setDongCode(dongCode1);
        areaFavorite.setUser(user1);

        return areaFavoriteRepository.save(areaFavorite);
    }

    public List<AreaFavorite> findId(Long userId){
        User user = userRepository.findById(userId).get();
        System.out.println(user.toString()+" 241245125125");
        return areaFavoriteRepository.findByUser(user);

    }

}
