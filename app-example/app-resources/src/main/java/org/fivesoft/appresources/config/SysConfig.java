package org.fivesoft.appresources.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统配置
 * @author wenx
 * @date 2020-07-16
 */
@Data
@Component
@ConfigurationProperties(prefix = "sys-config")
public class SysConfig {


}
