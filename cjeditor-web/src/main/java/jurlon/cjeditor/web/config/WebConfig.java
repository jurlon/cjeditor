package jurlon.cjeditor.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 18:01
 * @FileName: WebConfig
 * @Description
 */
@Slf4j
@Configuration
public class WebConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        String path = "application-mybatis.yml";
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(path));//class引入
        //yaml.setResources(new FileSystemResource(path));//File引入
        //yaml.setResources(new ClassPathResource("application-mybatis.yml"));
        configurer.setProperties(yaml.getObject());
        loadClassPathFiles();
        return configurer;
    }
    public void loadClassPathFiles(){
        try {
            File dir= ResourceUtils.getFile("classpath:");
            if(!dir.isDirectory()){
                return;
            }
            File[] files = dir.listFiles();
            for(File f : files){
                log.info(f.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
