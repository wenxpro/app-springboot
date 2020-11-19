package org.fivesoft.config;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import org.fivesoft.cache.UserCache;
import org.fivesoft.context.constant.ConstantContextHolder;
import org.fivesoft.login.SysLoginUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 用户缓存配置
 * @author wenx
 * @date 2020-11-19
 */
@Configuration
public class CacheConfig {

    /**
     * 登录用户的缓存，默认过期时间，根据系统sys_config中的常量决定
     *
     * @author stylefeng
     * @date 2020/7/9 11:44
     */
    @Bean
    public UserCache userCache() {
        TimedCache<String, SysLoginUser> timedCache =
                CacheUtil.newTimedCache(ConstantContextHolder.getSessionTokenExpireSec() * 1000);

        //定时清理缓存，间隔1秒
        timedCache.schedulePrune(1000);

        return new UserCache(timedCache);
    }


}
