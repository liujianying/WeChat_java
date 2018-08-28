package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static volatile d fuD;
    Map<String, c> fuE = new ConcurrentHashMap();

    private d() {
    }

    public static d aeQ() {
        if (fuD == null) {
            synchronized (d.class) {
                if (fuD == null) {
                    fuD = new d();
                }
            }
        }
        return fuD;
    }

    public final c su(String str) {
        if (!bi.oW(str)) {
            return (c) this.fuE.get(str);
        }
        x.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
        return null;
    }
}
