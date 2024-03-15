package com.tjl.cloud.apis;

import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.entities.dto.PayDTO;
import com.tjl.cloud.resp.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-payment-service")

public interface PayFeignApi {

    /**
     * 根据id查询
     * 此处@PathVariable("id") 不加上("id")会导致报错
     **/
    @GetMapping("/pay/{id}")
    R<Pay> getById(@PathVariable("id") Integer id);

    @PostMapping("/pay")
    R<Integer> add(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/info")
    R<String> getInfo();

    @GetMapping(value = "/pay/circuit/{id}")
    R<String> myCircuit(@PathVariable("id") Integer id);

    /**
     * Resilience4j Bulkhead 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);


    /**
     * Resilience4j Ratelimit 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);


}
