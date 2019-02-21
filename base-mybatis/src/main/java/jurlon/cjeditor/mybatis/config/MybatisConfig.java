package jurlon.cjeditor.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 18:02
 * @FileName: MybatisConfig
 * @Description
 */
@Configuration
@MapperScan(basePackages = "jurlon.cjeditor.mybatis.mapper")//扫描mapper
public class MybatisConfig {
}
