package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.aa.a;

public final class c extends j {
    private static volatile c flc = null;

    static /* synthetic */ void a(c cVar, int i, int i2, long j, boolean z, Bundle bundle) {
        if (g.Eg().Dx()) {
            Object obj = (1 == i || 3 == i) ? 1 : null;
            if (obj != null) {
                long longValue = ((Long) g.Ei().DT().get(a.sTD, Long.valueOf(-1))).longValue();
                int i3 = (z || longValue <= 0) ? Integer.MAX_VALUE : (int) longValue;
                new 4(cVar, i, i2, i3, i2, i, bundle, j).KM();
            }
        }
    }

    private c() {
    }

    public static c acK() {
        if (flc == null) {
            synchronized (c.class) {
                if (flc == null) {
                    flc = new c();
                }
            }
        }
        return flc;
    }

    public static void release() {
        flc = null;
    }

    public final void a(long j, boolean z, Bundle bundle) {
        com.tencent.mm.plugin.appbrand.r.c.Em().H(new 3(this, z, j, bundle));
    }

    public static boolean acL() {
        if (g.Eg().Dx()) {
            return ((Boolean) g.Ei().DT().get(a.sTC, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }
}
