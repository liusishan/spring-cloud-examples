package com.lss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lss
 * @Date: 2019/3/30 15:27
 * @Description:
 */
//@EnableCircuitBreaker 熔断器
//@EnableDiscoveryClient Eureka
//@SpringBootApplication
@EnableFeignClients
@SpringCloudApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
