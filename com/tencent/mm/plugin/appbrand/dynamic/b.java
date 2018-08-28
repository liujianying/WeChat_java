package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;

public final class b {
    private static ag fun;
    private static ag fuo;
    private static ag fup = new ag(Looper.getMainLooper());

    static {
        HandlerThread Xs = e.Xs("DynamicPage#WorkerThread");
        Xs.start();
        fun = new ag(Xs.getLooper());
        Xs = e.Xs("DynamicPage#IPCThread");
        Xs.start();
        fuo = new ag(Xs.getLooper());
    }

    public static ag aeO() {
        return fun;
    }

    public static boolean n(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        return fun.post(runnable);
    }

    public static boolean e(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        return fun.postDelayed(runnable, j);
    }

    public static boolean o(Runnable runnable) {
        return fup.post(runnable);
    }
}
