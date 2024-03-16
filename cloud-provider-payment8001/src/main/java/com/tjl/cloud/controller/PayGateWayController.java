package com.tjl.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.tjl.cloud.entities.Pay;
import com.tjl.cloud.resp.R;
import com.tjl.cloud.resp.ResultUtil;
import com.tjl.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.List;

@RestController
public class PayGateWayController
{
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public R<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);
        return R.ok(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public R<String> getGatewayInfo()
    {
        return R.ok("gateway info test："+ IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public R<String> getList(HttpServletRequest request)
    {
        //获取全部请求头
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements())
        {
            String header = headers.nextElement();
            System.out.println(header + ":" + request.getHeader(header));
        }
        return R.ok("success");
    }
}
