package com.zipbang.dotzipbang.service;

import com.zipbang.dotzipbang.entity.DealListView;
import com.zipbang.dotzipbang.entity.DongCode;
import com.zipbang.dotzipbang.repository.DealListViewRepository;
import com.zipbang.dotzipbang.repository.DongCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DongCodeService   {

    private final DongCodeRepository dongCodeRepository;
    private final DealListViewRepository dealListViewRepository;

    public List<DongCode> getSidoList(){
        return dongCodeRepository.getSidoList();
    }

    public List<DongCode> getGugunList(String dongCode){
        return dongCodeRepository.getGugunList(dongCode);
    }
    public List<DongCode> getDongList(String dongCode){
        return dongCodeRepository.getDongList(dongCode);
    }

    public List<DealListView> getApartList(String year,String month,String dongCode){
        return dealListViewRepository.findByApart(year, month, dongCode);
    }
}
