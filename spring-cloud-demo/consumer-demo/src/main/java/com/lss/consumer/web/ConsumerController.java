package com.lss.consumer.web;

import com.lss.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("{id}")
    public User queryById(@PathVariable Integer id) {
        String url = "http://localhost:8089/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
