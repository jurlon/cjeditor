package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.mybatis.model.NavigationBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 17:21
 * @FileName: Test1
 * @Description
 */
@Slf4j
@Configuration
public class Test1 {
    @Bean
    public static NavigationBar getBar(){
        NavigationBar bar = new NavigationBar();
        bar.setId(1);
        log.info("设置 navigationBar id=1");  
        return bar;
    }
}
