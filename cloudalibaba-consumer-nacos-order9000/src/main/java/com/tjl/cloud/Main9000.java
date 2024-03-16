package com.tjl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tjl
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9000 {
    public static void main(String[] args) {
        SpringApplication.run(Main9000.class, args);
    }
}