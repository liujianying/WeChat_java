package com.tencent.c.d.b;

import android.text.TextUtils;
import com.tencent.c.f.h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class e {
    private static Field c(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            h.k(th);
            return null;
        }
    }

    private static Class<?> acs(String str) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Throwable th) {
            h.k(th);
            return null;
        }
        if (cls == null) {
            return null;
        }
        return cls;
    }

    public static Object a(Class<?> cls, String str, Object obj) {
        try {
            Field c = c(cls, str);
            if (c == null) {
                return null;
            }
            return c.get(obj);
        } catch (Throwable th) {
            h.k(th);
            return null;
        }
    }

    public static Object gs(String str, String str2) {
        Object obj = null;
        try {
            return a(acs(str), str2, null);
        } catch (Throwable th) {
            h.k(th);
            return obj;
        }
    }

    private static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable th) {
            h.k(th);
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        try {
            return b(acs(str), str2, clsArr);
        } catch (Throwable th) {
            h.k(th);
            return null;
        }
    }
}
