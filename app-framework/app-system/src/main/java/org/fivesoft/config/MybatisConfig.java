package org.fivesoft.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.chinasoftinc.common.fieldfill.CustomMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis扩展插件配置
 *
 * @author wenx
 * @date 2020/3/18 10:49
 */
@Configuration
@MapperScan(basePackages = {"com.chinasoftinc.wxjdispatch.buz.**.mapper"})
public class MybatisConfig {

    /**
     * mybatis-plus分页插件
     *
     * @author xuyuxiang
     * @date 2020/3/31 15:42
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 自定义公共字段自动注入
     *
     * @author xuyuxiang
     * @date 2020/3/31 15:42
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new CustomMetaObjectHandler();
    }

}
