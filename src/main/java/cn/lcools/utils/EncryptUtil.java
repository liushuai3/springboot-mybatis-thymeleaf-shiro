package cn.lcools.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Copyright: Copyright (c) 2019 -Linkage
 *
 * @ClassName: EncryptUtil
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: liushuai3
 * @date: 2019/8/20 10:39
 * *****
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019/8/20     liushuai3           v1.0.0               修改原因
 */
public class EncryptUtil {

    public static String MD5Pwd(String username, String pwd) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数
        String md5Pwd = new SimpleHash("MD5", pwd,
                ByteSource.Util.bytes(username + "salt"), 2).toHex();
        return md5Pwd;
    }

    public static void main(String[] args) {
        String password = EncryptUtil.MD5Pwd("liushuai","123456");
        System.out.println(password);
    }
}
