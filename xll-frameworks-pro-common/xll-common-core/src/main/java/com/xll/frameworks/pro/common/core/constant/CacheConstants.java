package com.xll.frameworks.pro.common.core.constant;

/**
 * 功能描述: <br>
 * <p>
 * 〈缓存的key 常量〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:33
 */
public class CacheConstants {
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * 用户管理 cache key
     */
    public static final String SYS_USER_KEY = "sys_user:";

    /**
     * 用户管理 cache key
     */
    public static final String SYS_USER_UN_KEY = "sys_user_un:";

    /**
     * 部门管理 cache key
     */
    public static final String SYS_DEPT_KEY = "sys_dept:";

    /**
     * 列配置 cache key
     */
    public static final String SYS_TABLE_CONFIG_KEY = "sys_table_config:";

    /**
     * 部门管理 cache key
     */
    public static final String SYS_DEPT_DC_KEY = "sys_dept_dc:";

    /**
     * 角色管理 cache key
     */
    public static final String SYS_ROLE_KEY = "sys_role:";
}
