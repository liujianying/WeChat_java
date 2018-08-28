package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.x;

public final class j {
    public static final c flO = new c();

    public static final class e {
        public static final e fma = new e();

        static int ade() {
            if (g.Ei().DT().getBoolean(a.sTL, false)) {
                return 1;
            }
            int intValue = ((Integer) g.Ei().DT().get(a.sTI, Integer.valueOf(0))).intValue();
            if (intValue > 0) {
                return intValue + 1;
            }
            return intValue;
        }

        static void a(String str, long j, int i, int i2) {
            h.mEJ.h(14112, new Object[]{Integer.valueOf(1), bi.oV(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    private static void a(boolean z, long j) {
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = bi.VE() + Math.max(0, j);
            }
            g.Ei().DT().a(a.sTE, Long.valueOf(j2));
            g.Ei().DT().a(a.sTQ, Boolean.valueOf(true));
            g.Ei().DT().a(a.sTK, Boolean.valueOf(false));
            e eVar = e.fma;
            e.a((String) g.Ei().DT().get(a.sTF, ""), ((Long) g.Ei().DT().get(a.sTG, Long.valueOf(0))).longValue(), 1, e.ade());
            return;
        }
        g.Ei().DT().a(a.sTE, Long.valueOf(0));
    }

    private static void a(boolean z, long j, long j2) {
        long j3 = 0;
        x DT = g.Ei().DT();
        a aVar = a.sTN;
        if (z) {
            j3 = Math.max(0, j) + bi.VE();
        }
        DT.a(aVar, Long.valueOf(j3));
        x DT2 = g.Ei().DT();
        a aVar2 = a.sTP;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        DT2.a(aVar2, Long.valueOf(j2));
    }

    public static boolean acX() {
        i.acO();
        if (g.Eg().Dx()) {
            return ((Boolean) g.Ei().DT().get(a.sTQ, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static a acY() {
        int i = 0;
        if (!acZ()) {
            return a.flP;
        }
        int intValue = ((Integer) g.Ei().DT().get(a.sTH, Integer.valueOf(0))).intValue();
        a[] values = a.values();
        int length = values.length;
        while (i < length) {
            a aVar = values[i];
            if (aVar.value == intValue) {
                return aVar;
            }
            i++;
        }
        return a.flP;
    }

    public static boolean acZ() {
        if (!g.Eg().Dx()) {
            return false;
        }
        long longValue = ((Long) g.Ei().DT().get(a.sTE, Long.valueOf(0))).longValue();
        boolean z = longValue > bi.VE();
        if (!z && longValue > 0) {
            g.Ei().DT().a(a.sTE, Long.valueOf(0));
            e eVar = e.fma;
            e.a((String) g.Ei().DT().get(a.sTF, ""), ((Long) g.Ei().DT().get(a.sTG, Long.valueOf(0))).longValue(), 3, e.ade());
        }
        return z;
    }

    static void ada() {
        i.acO();
        if (g.Eg().Dx()) {
            e eVar = e.fma;
            if (!((Boolean) g.Ei().DT().get(a.sTK, Boolean.valueOf(false))).booleanValue()) {
                e.a((String) g.Ei().DT().get(a.sTF, ""), ((Long) g.Ei().DT().get(a.sTG, Long.valueOf(0))).longValue(), 0, e.ade());
                g.Ei().DT().a(a.sTK, Boolean.valueOf(true));
            }
        }
    }

    public static void adb() {
        if (g.Eg().Dx() && acZ()) {
            a(false, 0);
            a(false, 0, 0);
            e eVar = e.fma;
            e.a((String) g.Ei().DT().get(a.sTF, ""), ((Long) g.Ei().DT().get(a.sTG, Long.valueOf(0))).longValue(), 2, e.ade());
        }
    }
}
