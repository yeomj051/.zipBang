package com.zipbang.dotzipbang.Controller;

import com.zipbang.dotzipbang.entity.DealListView;
import com.zipbang.dotzipbang.entity.DongCode;
import com.zipbang.dotzipbang.service.DongCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
public class DongCodeController {


    private final DongCodeService dongCodeService;

    @GetMapping("/sido")
    public ResponseEntity<?> getSido(){
        return new ResponseEntity<List<DongCode>>(dongCodeService.getSidoList(), HttpStatus.OK);
    }

    @GetMapping("/gugun")
    public ResponseEntity<?> getGugun(@RequestParam String dongCode){
        return new ResponseEntity<List<DongCode>>(dongCodeService.getGugunList(dongCode.substring(0,2)), HttpStatus.OK);
    }

    @GetMapping("/dong")
    public ResponseEntity<?> getDong(@RequestParam String dongCode){
        return new ResponseEntity<List<DongCode>>(dongCodeService.getDongList(dongCode.substring(0,4)), HttpStatus.OK);
    }
    @GetMapping("/apart-list")
    public ResponseEntity<?> getApartList(@RequestParam String year,@RequestParam String dongCode){
        return new ResponseEntity<List<DealListView>>(dongCodeService.getApartList(year,dongCode), HttpStatus.OK);
    }

}
