package service;

import com.imooc.springboot.study.SpringBootStudyApplication;
import com.imooc.springboot.study.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by fengwei on 2020/3/4.
 * 异步服务测试
 */
@Slf4j
@SpringBootTest(classes = SpringBootStudyApplication.class)
@RunWith(SpringRunner.class)

public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws InterruptedException{
        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess .....");
    }

    @Test
    public void testAsyncProcessHasReturn() throws Exception{
        long start =System.currentTimeMillis();

        Future<Integer> result=asyncService.asyncProcessHasReturn();
//        log.info("get async task value: {}",result.get());
        log.info("get async task value: {}",
                result.get(1, TimeUnit.SECONDS));
        log.info("time elapse for async task: {} ms",
                System.currentTimeMillis()-start);
    }


}
