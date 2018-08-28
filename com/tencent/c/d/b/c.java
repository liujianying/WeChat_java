package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c {
    private static Object vjs;
    private static Method vjt;
    private static boolean vju;

    static {
        vjs = null;
        vjt = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                vjs = e.gs("libcore.io.Libcore", "os");
                vjt = e.a("libcore.io.Os", "stat", new Class[]{String.class});
                vju = true;
                return;
            } catch (Throwable th) {
            }
        }
        vju = false;
    }

    public static boolean isAvailable() {
        return vju;
    }

    public static int acr(String str) {
        if (!vju) {
            return 0;
        }
        Object invoke = vjt.invoke(vjs, new Object[]{str});
        if (invoke != null) {
            return ((Integer) e.a(invoke.getClass(), "st_mode", invoke)).intValue();
        }
        return 0;
    }
}
