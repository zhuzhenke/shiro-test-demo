package com.shiro.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/15
 * Time: 10:15
 * Version: 1.0
 */
public class CryptographyUtil {

    /**
     * 加密
     */
    public static String encBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * 解密
     */
    public static String decBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * md5加密
     */
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }


}
