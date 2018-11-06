package com.kadh.o2o.web.superadmin;

import com.kadh.o2o.entity.Area;
import com.kadh.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/list")
    @ResponseBody
    private Map<String, Object> listArea() {
        System.out.println("888888888888888888888888888888");
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
        try {
            list = areaService.getAreaList();
            modelMap.put("success", true);
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
