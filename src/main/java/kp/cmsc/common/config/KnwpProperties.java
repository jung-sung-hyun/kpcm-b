package kp.cmsc.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "knwp")
@Validated
@Data
public class  KnwpProperties {
    private String uploadPath;
    private String jedisPath;
    private int    jedisPort;
}
