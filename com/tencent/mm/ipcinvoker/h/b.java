package com.tencent.mm.ipcinvoker.h;

import com.tencent.mm.ipcinvoker.h.a.a;

public final class b {
    private static a dnj = new a();

    public static boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        dnj = aVar;
        return true;
    }

    public static void i(String str, String str2, Object... objArr) {
        dnj.a(4, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        dnj.a(6, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        dnj.a(5, str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        dnj.a(3, str, str2, objArr);
    }
}
