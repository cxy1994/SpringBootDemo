package com.cxy.demo.controller;

import com.cxy.demo.entity.Area;
import com.cxy.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/listarea")
    private Map<String,Object> getArea(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Area> list = areaService.getAllArea();
        map.put("areaList",list);
        return map;
    }

    @GetMapping("/getarea")
    public Map<String, Object> getAreaByAreaId(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @PostMapping("/addarea")
    public Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @PostMapping("/modifyarea")
    public Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @GetMapping("/delarea")
    public Map<String, Object> deleteArea(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }

}
