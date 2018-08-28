package com.tencent.mm.plugin.appbrand.appcache.a.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final int fiY = 1;
    public static final a fiZ = new 1();
    public static final a fja = new 2();
    public static final a fjb = new 3();
    public static final a fjc = new 4();
    private static final /* synthetic */ int[] fjd = new int[]{fiY};

    public static void n(long j, long j2) {
        if (j2 < 0) {
            x.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", Long.valueOf(j), Long.valueOf(j2));
            return;
        }
        if (j > 0) {
            h.mEJ.e(j, j2, 1);
            h.mEJ.h(15272, Long.valueOf(j), Long.valueOf(j2));
        }
        if (843 != j) {
            h.mEJ.e(843, j2, 1);
            h.mEJ.h(15272, Integer.valueOf(843), Long.valueOf(j2));
        }
    }
}
