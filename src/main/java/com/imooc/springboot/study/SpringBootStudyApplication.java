package com.imooc.springboot.study;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by fengwei on 2020/3/4.
 * @EnableScheduling 允许开启定时任务
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ComponentScan("com.imooc.springboot.study")
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        //1.通过静态run方法
//        SpringApplication.run(SpringBootStudyApplication.class,args);
//
        // 2.通过api调整应用行为
//        SpringApplication application=new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

        //3.SpringApplicationBuilder Fluent Api,链式调用
        new SpringApplicationBuilder(SpringBootStudyApplication.class)
                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
                .run(args);

    }
}
