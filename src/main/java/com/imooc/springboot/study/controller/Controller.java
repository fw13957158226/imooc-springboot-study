package com.imooc.springboot.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.springboot.study.config.SpringBootConfig;
import com.imooc.springboot.study.vo.Imoocer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by fengwei on 2020/3/4.
 */
@RestController
@Slf4j
@RequestMapping("/springboot")
public class Controller {
    @Value("${imooc.springboot.version}")
    private String version;
    @Value("${imooc.springboot.name}")
    private String name;

    private final ObjectMapper mapper;


    private final SpringBootConfig springBootConfig;

    @Autowired
    public Controller(ObjectMapper mapper, SpringBootConfig springBootConfig) {
        this.mapper = mapper;
        this.springBootConfig = springBootConfig;
    }

    /**
     * 第一种方式的数据诸如
     */
    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject: {},{}",version,name);
    }

    @GetMapping("/conf_inject_2")
    public void secondConfInject(){
        System.out.println("11111");
        log.info("second conf inject: {},{}",springBootConfig.getVersion(),springBootConfig.getName());

    }

    @GetMapping("/jackson")
    public Imoocer jackson() throws Exception{
        Imoocer imoocer=Imoocer.builder()
                .name("fengwei")
                .age(19)
                .address("shanghai")
                .registerTime(new Date())
                .build();

        String jsonImoocer=mapper.writeValueAsString(imoocer);
        log.info("imoocer jackson: {}",jsonImoocer);

        return mapper.readValue(jsonImoocer,Imoocer.class);

    }
}
