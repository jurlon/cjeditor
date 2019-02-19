package jurlon.cjeditor.web.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 18:01
 * @FileName: WebConfig
 * @Description
 */
@Configuration
public class WebConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        String path = "application-web.yml";
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(path));//class引入
        //yaml.setResources(new FileSystemResource(path));//File引入
        //yaml.setResources(new ClassPathResource("application-mybatis.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
