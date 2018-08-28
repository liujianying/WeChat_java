package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class y {
    private static Class<?> Yw;
    private static Method dfA;
    private static Method dfz;

    static {
        Yw = null;
        dfz = null;
        dfA = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            Yw = cls;
            dfz = cls.getDeclaredMethod("get", new Class[]{String.class});
            dfA = Yw.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            dfz.setAccessible(true);
            dfA.setAccessible(true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
        }
    }

    public static String get(String str) {
        try {
            return (String) dfz.invoke(null, new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            return null;
        }
    }
}
