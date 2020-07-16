package com.zy.more.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangyao
 * @create:2020-07-03 09:54
 **/
//@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLevel(){
        return Logger.Level.FULL;
    }
}
