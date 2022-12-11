package com.xll.frameworks.pro.system.temp.cache;

import com.xll.frameworks.pro.common.core.constant.CacheConstants;
import com.xll.frameworks.pro.common.core.core.domain.model.LoginUser;
import com.xll.frameworks.pro.common.core.core.redis.RedisCache;
import com.xll.frameworks.pro.common.core.utils.spring.SpringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 验证码缓存
 *
 * @author ruoyi
 */
@Component
public class LoginTokenUtils implements CacheUtil {

    private static final String CACHE_NAME = "loginTokens";

    private static final RedisCache REDIS_CACHE;

    static {
        REDIS_CACHE = SpringUtils.getBean(RedisCache.class);
    }


    @Override
    public String getCacheName() {
        return CACHE_NAME;
    }

    @Override
    public String getCacheId() {
        return "loginTokenUtils";
    }

    @Override
    public String getCacheValue(String key) {
        LoginUser loginUser = REDIS_CACHE.getCacheObject(key);
        if (null != loginUser) {
            return loginUser.toString();
        } else {
            return "";
        }
    }

    @Override
    public String getRemark() {
        return "登录用户";
    }

    @Override
    public void clearCache() {
        REDIS_CACHE.redisTemplate.delete(getCacheKeys());
    }

    @Override
    public void clearCacheByKeys(String... keys) {
        REDIS_CACHE.deleteKey(keys);
    }

    @Override
    public Collection<String> getCacheKeys() {
        return REDIS_CACHE.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
    }
}
