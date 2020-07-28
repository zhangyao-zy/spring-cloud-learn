package com.zy.more.config.security;

import com.zy.more.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author: zhangyao
 * @create:2020-07-21 15:28
 * 配置gateway集成springsecurity
 **/
@EnableWebFluxSecurity
public class SecurityCoreConfig {
//   @Bean
//    public MapReactiveUserDetailsService userDetailsService(){
//       List list = new ArrayList();
//       GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
//       list.add(grantedAuthority);
//       return  new MapReactiveUserDetailsService(new User("zhangyao","000000",list));
//   }

    /**
     * 配置过滤规则
     * @param httpSecurity
     * @return
     */
   @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
       httpSecurity.authorizeExchange().anyExchange().authenticated()
               .and().httpBasic()
               .and().formLogin();
       return  httpSecurity.build();
   }


   /**
    * @Date: 2020/7/27 16:07
    * @Author: zhangyao
    * @Description: 通过openfeign调用user服务,查询用户
    * @return: org.springframework.security.core.userdetails.ReactiveUserDetailsService
    **/
   @Bean
    public ReactiveUserDetailsService userDetailsService(){
       return new UserDetailServiceImpl();
   }

}