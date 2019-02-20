package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.mybatis.model.NavigationBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 17:23
 * @FileName: Test2
 * @Description
 */
@Slf4j
@Configuration
public class Test2 {
    @Bean
    public static NavigationBar getBar(){
        NavigationBar bar = new NavigationBar();
        bar.setName("张鸿涂");
        log.info("设置 navigationBar name=张鸿涂");
        return bar;
    }
}