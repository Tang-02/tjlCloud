package com.tjl.cloud.mypredicates;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author tjl
 * @version 1.0
 * 需求说明：按照管用户类型进行判断是否可访问接口 userType = S A B C D
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    //以短格式编写时自动寻找的字段
    private final String KEY = "userType";

    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    //不实现该方法 在配置文件中无法以短格式进行配置 例如 - My=A
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(KEY);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //获取请求头中的userType参数
                String userType = serverWebExchange.getRequest().getHeaders().getFirst("userType");

                if (userType== null || userType.isBlank()){
                    return false;
                }
                //符合配置文件中配置的参数允许访问
                if (userType.equalsIgnoreCase(config.getUserType())){
                    return true;
                }
                return false;
            }
        };
    }

    //断言规则
    @Setter
    @Getter
    @Validated
    public static class Config{
        @NotNull
        private String userType;
    }
}
