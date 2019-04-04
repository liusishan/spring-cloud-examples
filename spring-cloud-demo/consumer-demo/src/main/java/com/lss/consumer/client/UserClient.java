package com.lss.consumer.client;

import com.lss.consumer.config.FeignConfig;
import com.lss.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: lss
 * @Date: 2019/4/4 14:24
 * @Description:
 */
@FeignClient(value = "user-service", fallback = UserClientFallback.class, configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Integer id);
}
