package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.report.service.h;

public final class l {
    public static void s(String str, String str2, int i) {
        h.mEJ.h(12651, new Object[]{Integer.valueOf(1), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void t(String str, String str2, int i) {
        h.mEJ.h(12651, new Object[]{Integer.valueOf(2), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void u(String str, String str2, int i) {
        h.mEJ.h(12651, new Object[]{Integer.valueOf(3), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void b(String str, String str2, int i, boolean z) {
        if (z) {
            h.mEJ.h(12651, new Object[]{Integer.valueOf(4), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
            return;
        }
        h.mEJ.h(12651, new Object[]{Integer.valueOf(4), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }

    public static void c(String str, String str2, int i, boolean z) {
        if (z) {
            h.mEJ.h(12651, new Object[]{Integer.valueOf(5), str, Integer.valueOf(1), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
            return;
        }
        h.mEJ.h(12651, new Object[]{Integer.valueOf(5), str, Integer.valueOf(0), str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)});
    }
}
