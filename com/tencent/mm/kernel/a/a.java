package com.tencent.mm.kernel.a;

import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;

public final class a {
    public static long drq;
    public static long drr;
    public b dro;
    public b drp;
    public volatile boolean mConfigured = false;

    public static final void j(String str, Object... objArr) {
        if (objArr.length == 0) {
            j.i("MMSkeleton.Boot", str, new Object[0]);
        } else {
            j.i("MMSkeleton.Boot", str, objArr);
        }
    }

    public static String aQ(long j) {
        return (System.currentTimeMillis() - j) + "ms";
    }
}
