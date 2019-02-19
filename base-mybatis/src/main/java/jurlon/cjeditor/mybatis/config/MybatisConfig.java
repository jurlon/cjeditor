package jurlon.cjeditor.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 18:02
 * @FileName: MybatisConfig
 * @Description
 */
@Configuration
@MapperScan(basePackages = "jurlon.cjeditor.mybatis.mapper")//扫描mapper
public class MybatisConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        String path = "application-mybatis.yml";
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(path));//class引入
        //yaml.setResources(new FileSystemResource(path));//File引入
        //yaml.setResources(new ClassPathResource("application-mybatis.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
