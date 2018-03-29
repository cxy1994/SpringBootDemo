package com.cxy.demo.dao;

import com.cxy.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> list = areaDao.queryArea();
        //判断输出值是否符合预期
        assertEquals(2,list.size());
        System.out.print(list);
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        area.setCreateTime(new Date());
        int num = areaDao.insertArea(area);
        assertEquals(1,num);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        int num = areaDao.updateArea(area);
        assertEquals(1,num);
    }

    @Test
    public void deleteArea() {
        int num = areaDao.deleteArea(3);
        assertEquals(1,num);
    }
}