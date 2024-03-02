package com.tjl.cloud.controller;

import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.entities.dto.PayDTO;
import com.tjl.cloud.resp.R;
import jakarta.annotation.Resource;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 27701
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";


    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/pay/get/{id}")
    public R getPayInfoById(@PathVariable Integer id) {
        R res = restTemplate.getForObject(PAYMENT_URL + "/pay/" + id, R.class);
        log.info("获取支付信息结果:"+res);
        return res;
    }

    @GetMapping("/consumer/pay/info")
    public R getPayInfo() {
        R res = restTemplate.getForObject(PAYMENT_URL + "/pay/info", R.class);
        log.info("获取信息结果:"+res);
        return res;
    }

    @PostMapping("/consumer/pay/add")
    public R addOrder(@RequestBody PayDTO payDTO) {
       return restTemplate.postForObject(PAYMENT_URL+"/pay", payDTO, R.class);
    }
    @PutMapping("/consumer/pay/update")
    public R putOrder(@RequestBody Pay pay) {
        restTemplate.put(PAYMENT_URL+"/pay", pay);
        return R.ok();
    }

    @DeleteMapping("/consumer/pay/del/{id}")
    public R delPayInfo(@PathVariable Integer id) {
         restTemplate.delete(PAYMENT_URL + "/pay/" + id);
         return R.ok();
    }

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }
}
