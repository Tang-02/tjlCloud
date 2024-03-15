package com.tjl.cloud.controller;

import com.tjl.cloud.apis.GateWayFeignApi;
import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.resp.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {

    @Resource
    GateWayFeignApi gateway;


    @GetMapping(value = "gateway/{id}")
    public R<Pay> myRatelimit(@PathVariable("id") Integer id)
    {
        return gateway.getById(id);
    }

}
