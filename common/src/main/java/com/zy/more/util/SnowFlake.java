package com.zy.more.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author: zhangyao
 * @create:2020-07-01 09:04
 **/
@Component
public class SnowFlake {

    private long workerId;

    @Value("${datacenterId}")
    private long datacenterId;

    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    @PostConstruct
    private void init(){
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
            e.printStackTrace();
            workerId = NetUtil.getLocalhost().hashCode();
        }
    }


    public synchronized long getSnowflakeId(){
        return snowflake.nextId();
    }

    public synchronized long getSnowflake(long workerId,long datacenterId){
        Snowflake snowflake = new Snowflake(workerId, datacenterId);
        return  snowflake.nextId();
    }

}
