package com.zipbang.dotzipbang.Controller;

import com.zipbang.dotzipbang.entity.AreaFavorite;
import com.zipbang.dotzipbang.entity.DongCode;
import com.zipbang.dotzipbang.service.AreaFavoriteService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
@RequiredArgsConstructor

@Api("관심지역 컨트롤러  API V1")
public class AreaFavoriteController {

    private final AreaFavoriteService areaFavoriteService;

    @GetMapping("/list")
    public ResponseEntity<?> getAreaList(@RequestParam Long userId){
        return new ResponseEntity<List<AreaFavorite>>(areaFavoriteService.findId(userId),  HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> AreaAdd(@RequestBody Map<String, String> param){
        return new ResponseEntity<AreaFavorite >(areaFavoriteService.save(param.get("email"),param.get("dongCode")),  HttpStatus.OK);
    }
}
