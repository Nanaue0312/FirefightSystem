package com.firefight.utils;

import org.springframework.util.DigestUtils;

public class SignUtils {

    /**
     * 验证签名
     * 生成逻辑：Md5(appId+timestamp+appSecret)
     */
    public static boolean verifySign(String appId, String timestamp, String appSecret, String sign) {
        if (appId == null || timestamp == null || appSecret == null || sign == null) {
            return false;
        }

        String content = appId + timestamp + appSecret;
        String expectedSign = DigestUtils.md5DigestAsHex(content.getBytes());

        return expectedSign.equalsIgnoreCase(sign);
    }

    /**
     * 生成签名
     */
    public static String generateSign(String appId, String timestamp, String appSecret) {
        String content = appId + timestamp + appSecret;
        return DigestUtils.md5DigestAsHex(content.getBytes());
    }
}