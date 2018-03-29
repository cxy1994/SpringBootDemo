package com.cxy.demo.service.impl;

import com.cxy.demo.dao.AreaDao;
import com.cxy.demo.entity.Area;
import com.cxy.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAllArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int id) {
        return areaDao.queryAreaById(id);
    }

    @Override
    @Transactional
    public boolean insertArea(Area area) {
        if(area != null){
            if(area.getAreaName() != null && !"".equals(area.getAreaName())){
                area.setCreateTime(new Date());
                area.setLastEditTime(new Date());
                try{
                    int num = areaDao.insertArea(area);
                    if(num > 0){
                        return true;
                    }else{
                        throw new RuntimeException("operation error!");
                    }
                }catch (Exception e){
                    throw new RuntimeException("operation error! caused by :" + e.getMessage());
                }
            }else{
                throw new RuntimeException("area can not be null!");
            }
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int num = areaDao.updateArea(area);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("operation error!");
                }
            }catch (Exception e){
                throw new RuntimeException("operation error! caused by :" + e.getMessage());
            }
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int id) {
        if(id > 0){
            try{
                int num = areaDao.deleteArea(id);
                if(num > 0){
                    return true;
                }else{
                    throw new RuntimeException("operation error!");
                }
            }catch (Exception e){
                throw new RuntimeException("operation error! caused by :" + e.getMessage());
            }
        }else{
            return false;
        }
    }
}
