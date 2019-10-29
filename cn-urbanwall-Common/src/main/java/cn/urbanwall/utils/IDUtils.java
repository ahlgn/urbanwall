package cn.urbanwall.utils;

import java.util.UUID;

public final class IDUtils {
    /**
     * UUID 返回随机定义字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
