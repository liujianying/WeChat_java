package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e fuF;
    public Map<String, WeakReference<View>> fuG = new ConcurrentHashMap();

    private e() {
    }

    public static e aeR() {
        if (fuF == null) {
            synchronized (e.class) {
                if (fuF == null) {
                    fuF = new e();
                }
            }
        }
        return fuF;
    }

    public final View sv(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
            return null;
        }
        WeakReference weakReference = (WeakReference) this.fuG.get(str);
        return weakReference != null ? (View) weakReference.get() : null;
    }
}
