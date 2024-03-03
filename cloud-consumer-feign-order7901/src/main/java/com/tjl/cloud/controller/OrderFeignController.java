package com.tjl.cloud.controller;

import com.tjl.cloud.apis.PayFeignApi;
import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.entities.dto.PayDTO;
import com.tjl.cloud.resp.R;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TJL
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class OrderFeignController {

    @Resource
    PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public R addOrder(@RequestBody PayDTO payDTO){
        R<Integer> add = payFeignApi.add(payDTO);
        System.out.println("请求结果："+add);
        return add;
    }

    @GetMapping("/pay/{id}")
    public R getById(@PathVariable Integer id){
        R<Pay> byId = payFeignApi.getById(id);
        System.out.println("调用payFeignApi.getById(id)："+byId);
        return byId;
    }

    /**
     * openfeign 天然支持负载均衡
     */
    @GetMapping("/pay/info")
    public R getPayInfo(){
        R<String> info = payFeignApi.getInfo();
        System.out.println("调用payFeignApi.getInfo()："+info);
        return info;
    }
}
