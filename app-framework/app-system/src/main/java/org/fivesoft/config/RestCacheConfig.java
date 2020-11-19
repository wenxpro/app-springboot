package org.fivesoft.config;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import org.fivesoft.cache.MappingCache;
import org.fivesoft.cache.ResourceCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 缓存的配置，默认使用基于内存的缓存，如果分布式部署请更换为redis
 *
 * @author xuyuxiang
 * @date 2020/7/9 11:43
 */
@Configuration
public class RestCacheConfig {

    /**
     * mapping映射缓存
     *
     * @author fengshuonan
     * @date 2020/7/24 13:55
     */
    @Bean
    public MappingCache mappingCache() {
        TimedCache<String, Map<String, Object>> timedCache =
                CacheUtil.newTimedCache(2 * 60 * 1000);

        // 定时清理缓存，间隔1秒
        timedCache.schedulePrune(1000);

        return new MappingCache(timedCache);
    }


    /**
     * url资源的缓存，默认不过期
     *
     * @author stylefeng
     * @date 2020/7/9 11:44
     */
    @Bean
    public ResourceCache resourceCache() {
        return new ResourceCache();
    }

}
