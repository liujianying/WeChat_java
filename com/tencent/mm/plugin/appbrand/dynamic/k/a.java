package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

public final class a {
    public static <T extends com.tencent.mm.kernel.c.a> T z(Class<T> cls) {
        T l = g.l(cls);
        if (l != null) {
            return l;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        if (g.Ek().dqL.drf) {
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        1 1 = new 1(countDownLatch);
        g.Ek().a(1);
        try {
            countDownLatch.await();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SyncGetter", e, "", new Object[0]);
        } finally {
            g.Ek().b(1);
        }
        return g.l(cls);
    }
}
