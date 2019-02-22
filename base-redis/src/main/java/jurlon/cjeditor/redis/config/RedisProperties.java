package jurlon.cjeditor.redis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/22 13:43
 * @FileName: RedisProperties
 * @Description
 */
@Getter
@Setter
@Component
public class RedisProperties {
    @Value("${redis.prefix}")
    private String redisPrefix;
}
