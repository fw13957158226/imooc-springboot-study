package com.imooc.springboot.study.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by fengwei on 2020/3/4.
 *
 * 由于后面章节不需要打印定时任务，因此先将component注释掉
 */
//@Component
@Slf4j
public class BootSchedule {
    private final DateTimeFormatter fmt=DateTimeFormatter.ofPattern("HH:mm:ss");

    //上一次开始之后3s开始执行
    @Scheduled(fixedRate=3000)
    public void schedule01(){
        log.info("achedule01  -> {}", LocalDateTime.now().format(fmt));
    }

    //上一次执行之后3s开始执行
    @Scheduled(fixedDelay=3000)
    public void schedule02(){
        log.info("achedule02  -> {}", LocalDateTime.now().format(fmt));
    }

    //第一次延迟2s执行，后每次3s开始执行
    @Scheduled(initialDelay=2000,fixedRate = 30000)
    public void schedule03(){
        log.info("achedule03  -> {}", LocalDateTime.now().format(fmt));
    }

    //第一次延迟2s执行，后每次3s开始执行
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04(){
        log.info("achedule04  -> {}", LocalDateTime.now().format(fmt));
    }

}
