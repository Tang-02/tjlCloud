package com.tjl.cloud.controller;

import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.entities.dto.PayDTO;
import com.tjl.cloud.resp.R;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 27701
 */
@RestController
@RequestMapping("/order")
@NoArgsConstructor
public class OrderController {

    //先写死
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public R addOrder(@RequestBody PayDTO payDTO) {
       return restTemplate.postForObject(PAYMENT_URL+"/pay", payDTO, R.class);
    }
    @PutMapping("/consumer/pay/update")
    public R putOrder(@RequestBody Pay pay) {
        restTemplate.put(PAYMENT_URL+"/pay", pay);
        return R.ok();
    }
    @GetMapping("/consumer/pay/get/{id}")
    public R getPayInfo(@PathVariable Integer id) {
        return restTemplate.getForObject(PAYMENT_URL+"/pay/"+id, R.class);
    }

    @DeleteMapping("/consumer/pay/del/{id}")
    public R delPayInfo(@PathVariable Integer id) {
         restTemplate.delete(PAYMENT_URL + "/pay/" + id);
         return R.ok();
    }
}
