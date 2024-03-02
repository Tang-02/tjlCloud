package com.tjl.cloud.controller;


import com.alibaba.fastjson2.JSON;
import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.resp.R;
import com.tjl.cloud.service.PayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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

}