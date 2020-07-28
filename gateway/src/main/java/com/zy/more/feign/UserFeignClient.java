package com.zy.more.feign;

import com.zy.more.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: zhangyao
 * @create:2020-07-23 17:38
 **/
@FeignClient(name = "user",path = "/user")
public interface UserFeignClient {
    @GetMapping("/{name}")
    public Result getUserByName(@PathVariable("name") String name);
}
