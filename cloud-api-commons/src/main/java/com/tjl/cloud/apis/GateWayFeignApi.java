package com.tjl.cloud.apis;

import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.resp.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-gateway")
public interface GateWayFeignApi {

    @GetMapping(value = "/pay/gateway/get/{id}")
    public R<Pay> getById(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/info")
    public R<String> getGatewayInfo();
}
