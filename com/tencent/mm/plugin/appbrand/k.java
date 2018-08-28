package com.tencent.mm.plugin.appbrand;

import android.support.v4.e.a;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    private static final Map<String, k> dmH = new a();
    private static final k fdF = new k();
    public volatile String fdG;
    public final AtomicInteger fdH = new AtomicInteger();
    public final AtomicBoolean fdI = new AtomicBoolean(false);
    public int fdJ = 0;
    public volatile adz fdK;
    public volatile String fdL;
    public volatile String fdM;
    public volatile boolean fdN;

    private k() {
    }

    static k qr(String str) {
        return qs(str);
    }

    private static k qs(String str) {
        if (bi.oW(str)) {
            return null;
        }
        k kVar;
        synchronized (dmH) {
            kVar = (k) dmH.get(str);
            if (kVar == null) {
                kVar = new k();
                dmH.put(str, kVar);
            }
        }
        return kVar;
    }

    private static k qt(String str) {
        if (bi.oW(str)) {
            return null;
        }
        k kVar;
        synchronized (dmH) {
            kVar = (k) dmH.get(str);
        }
        return kVar;
    }

    static void remove(String str) {
        if (!bi.oW(str)) {
            synchronized (dmH) {
                dmH.remove(str);
            }
        }
    }

    public static k qu(String str) {
        k qt = qt(str);
        return qt == null ? fdF : qt;
    }

    public static k qv(String str) {
        return qs(str);
    }
}
