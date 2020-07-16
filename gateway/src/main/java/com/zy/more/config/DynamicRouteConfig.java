package com.zy.more.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;

import reactor.core.publisher.Mono;

/**
 * 动态路由，可以通过获取Bean才做该类，提供增删改查已经发布功能
 * @author wunaozai
 * @Date 2020-03-16
 */
@Service
public class DynamicRouteConfig implements ApplicationEventPublisherAware {

    private static final Logger log = LoggerFactory.getLogger(DynamicRouteConfig.class);

    @Autowired
    private RouteDefinitionWriter routedefinitionWriter;

    private ApplicationEventPublisher publisher;

    private String dataId = "gateway-router.properties";
    private String group = "DEFAULT_GROUP";
    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;
    @Value("${spring.cloud.nacos.config.namespace}")
    private String namespace;

    private static final List<String> ROUTE_LIST = new ArrayList<>();

    @PostConstruct
    public void dynamicRouteByNacosListener() {
        try {
            Properties prop = new Properties();
            prop.put("serverAddr", serverAddr);
            prop.put("namespace", namespace);
            ConfigService config = NacosFactory.createConfigService(prop);
            String content = config.getConfig(dataId, group, 5000);
            publisher(content);
            config.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String config) {
                    publisher(config);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加路由
     * @param def
     * @return
     */
    public Boolean addRoute(RouteDefinition def) {
        try {
            routedefinitionWriter.save(Mono.just(def)).subscribe();
            ROUTE_LIST.add(def.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * 删除路由
     * @return
     */
    public Boolean clearRoute() {
        for(String id: ROUTE_LIST) {
            routedefinitionWriter.delete(Mono.just(id)).subscribe();
        }
        ROUTE_LIST.clear();
        return false;
    }
    /**
     * 发布路由
     */
    private void publisher(String config) {
        clearRoute();
        try {
            log.info("重新更新动态路由");
            List<RouteDefinition> gateway = JSONObject.parseArray(config, RouteDefinition.class);
            for(RouteDefinition route: gateway) {
                addRoute(route);
            }
            publisher.publishEvent(new RefreshRoutesEvent(this.routedefinitionWriter));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher app) {
        publisher = app;
    }

}