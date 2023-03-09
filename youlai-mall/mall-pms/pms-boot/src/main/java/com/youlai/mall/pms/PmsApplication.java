package com.youlai.mall.pms;

import com.youlai.mall.ums.api.MemberFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {MemberFeignClient.class})
@EnableDiscoveryClient
public class PmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }
}
