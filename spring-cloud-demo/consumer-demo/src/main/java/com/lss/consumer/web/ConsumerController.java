package com.lss.consumer.web;

import com.lss.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: lss
 * @Date: 2019/3/30 17:15
 * @Description:
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private RibbonLoadBalancerClient client;

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @GetMapping("{id}")
//    public User queryById(@PathVariable Integer id) {
//        // 根据服务 id 获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        // 从实例中取出 ip 和端口
//        ServiceInstance instance = instances.get(0);
//        // 负载均衡算法 随机，轮询，hash，
//
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
//        System.out.println(url);
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

    //    @GetMapping("{id}")
//    public User queryById(@PathVariable Integer id) {
//
////        ServiceInstance instance = client.choose("user-service");
////        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
////        System.out.println(url);
//
//        String url = "http://user-service/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String queryById(@PathVariable Integer id) {
        String url = "http://user-service/user/" + id;
        String user = restTemplate.getForObject(url, String.class);
        return user;
    }

    public String queryByIdFallback(Integer id) {
        return "不好意思，服务器太拥挤了";
    }

}
