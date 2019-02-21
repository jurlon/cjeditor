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
import java.util.ArrayList;
import java.util.List;

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
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        //yaml.setResources(new FileSystemResource(path));//File引入
        //yaml.setResources(new ClassPathResource("application-mybatis.yml"));//class引入
        List<ClassPathResource> classPathResources = loadClassPathFiles();
        if(classPathResources!=null){
            yaml.setResources(classPathResources.toArray(new ClassPathResource[classPathResources.size()]));
            configurer.setProperties(yaml.getObject());
        }
        return configurer;
    }
    private List<ClassPathResource> loadClassPathFiles(){
        try {
            File dir= ResourceUtils.getFile("classpath:");
            if(!dir.isDirectory()){
                return null;
            }
            List<ClassPathResource> list = new ArrayList<>();
            File[] files = dir.listFiles();
            for(File f : files){
                if(f.getName().endsWith(".yml")){
                    log.info(f.getName());
                    list.add(new ClassPathResource(f.getName()));    
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
