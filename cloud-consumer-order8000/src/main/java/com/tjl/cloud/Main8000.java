package com.tjl.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 27701
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main8000 {
    public static void main(String[] args) {
        SpringApplication.run(Main8000.class, args);
    }
}