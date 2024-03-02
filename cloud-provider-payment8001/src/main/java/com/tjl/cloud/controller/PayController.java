package com.tjl.cloud.controller;


import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.resp.R;
import com.tjl.cloud.service.PayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 27701
 */
@RestController
@RequestMapping("/pay")
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;


    @GetMapping
    public R<List<Pay>> getAll(){
        return R.ok(payService.getList());
    }
    @GetMapping("/{id}")
    public R<Pay> getById(@PathVariable Integer id){
        log.info("收到请求信息 请求的PayId:"+id);
        if (id < 0) throw new RuntimeException("id不能小于0");
        return R.ok(payService.getById(id));
    }

    @PostMapping
    public R<Integer> add(@RequestBody Pay pay) {
        return R.ok( payService.add(pay));
    }

    @DeleteMapping("/{id}")
    public R<Integer> delete(@PathVariable Integer id) {
        if (id < 0) throw new RuntimeException("id不能小于0");
        return R.ok(payService.delete(id));
    }
    @PutMapping
    public R<Integer> update(@RequestBody Pay pay) {
        return R.ok( payService.update(pay));
    }


    @Value("${tjlCloud.info}")
    String info;

    @Value("${server.port}")
    String port;
    @GetMapping("/info")
    public R<String> getInfo(){
        System.out.println("收到请求 服务端口"+port);
        return R.ok(info + " port:"+port);
    }
}
