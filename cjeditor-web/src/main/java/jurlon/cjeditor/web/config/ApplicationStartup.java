package jurlon.cjeditor.web.config;

import jurlon.cjeditor.common.handler.ICacheHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/22 10:46
 * @FileName: ApplicationStartup
 * @Description 初始化操作可以用@Order(1)指定执行优先级 值越小优先级越高
 *              另外也可以用CommandLineRunner、默认ApplicationRunner比CommandLineRunner先执行
 */
@Slf4j
@Component
public class ApplicationStartup implements ApplicationRunner {
    
    @Autowired
    private ICacheHandler cacheHandler;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
      log.info("11111111111111111");
        cacheHandler.init();
    }
}
