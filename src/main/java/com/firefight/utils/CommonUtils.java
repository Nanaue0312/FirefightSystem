package com.firefight.utils;

import java.lang.reflect.Field;

public class CommonUtils {
    public static boolean isAnyFieldNull(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return true;
        }

        // 获取对象的所有字段
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // 设置为可访问私有字段
            Object value = field.get(obj); // 获取字段值

            // 判断字段是否为空
            if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                return true;
            }
        }
        return false;
    }
}
