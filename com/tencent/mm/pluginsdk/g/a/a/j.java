package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class j {
    private static final int qCu = i$b.DoCache.bWA;
    private static final int qCv = i$b.DoDelete.bWA;
    private static final int qCw = i$b.DoDecrypt.bWA;

    public enum a {
        ;

        static {
            qCx = 1;
            qCy = 2;
            qCz = 3;
            qCA = 4;
            qCB = 5;
            qCC = 6;
            qCD = new int[]{qCx, qCy, qCz, qCA, qCB, qCC};
        }
    }

    public static void n(long j, long j2) {
        if (j > 0 && 197 != j) {
            h.mEJ.a(j, j2, 1, false);
        }
        h.mEJ.a(197, j2, 1, false);
    }

    public static void fN(long j) {
        n(j, 2);
    }

    public static void a(int i, int i2, String str, int i3, int i4, boolean z, boolean z2, boolean z3, String str2) {
        a(i, i2, str, i3, qCu, z2 ? 0 : 1, i4 - 1, z3 ? 0 : 1, 1, z ? 0 : 1, str2);
    }

    public static void a(int i, int i2, int i3, boolean z, String str) {
        a(i, i2, "", i3, qCv, z ? 0 : 1, a.qCy - 1, 1, 1, 1, str);
    }

    public static void a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        a(i, i2, "", i3, qCw, z ? 0 : 1, a.qCy - 1, z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
    }

    private static void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        h.mEJ.h(11906, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)});
        if (!bi.oW(str2) && !str2.equals("0")) {
            h.mEJ.h(11907, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2});
        }
    }
}
