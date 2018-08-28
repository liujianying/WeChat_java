package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.j4log.Logger;

public class ax {
    static final Logger a = Logger.getLogger("jceClient");
    static int b = 15;

    public static void a(String str) {
        a.info(str);
    }

    public static void a(String str, Throwable th) {
        a.info(str, th);
    }

    public static void b(String str) {
        a.error(str);
    }

    public static void b(String str, Throwable th) {
        a.error(str, th);
    }

    public static void c(String str) {
        a.debug(str);
    }
}
