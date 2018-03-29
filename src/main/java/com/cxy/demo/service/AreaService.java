package com.cxy.demo.service;

import com.cxy.demo.entity.Area;

import java.util.List;

public interface AreaService {

    public List<Area> getAllArea();

    public Area getAreaById(int id);

    public boolean insertArea(Area area);

    public boolean modifyArea(Area area);

    public boolean deleteArea(int id);

}
