package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.WeakHashMap;

public class j {
    private static final WeakHashMap<g, j> fdB = new WeakHashMap();
    private static final j fdC = new 1();
    private final g fdD;
    public volatile String fdE;

    /* synthetic */ j() {
        this(null);
    }

    public static j g(g gVar) {
        if (gVar == null || bi.oW(gVar.mAppId)) {
            return fdC;
        }
        j jVar;
        synchronized (fdB) {
            jVar = (j) fdB.get(gVar);
            if (jVar == null) {
                jVar = new j(gVar);
                fdB.put(gVar, jVar);
            }
        }
        return jVar;
    }

    public static j qq(String str) {
        if (bi.oW(str)) {
            return fdC;
        }
        return g(a.pY(str));
    }

    private j(g gVar) {
        this.fdE = "";
        this.fdD = gVar;
    }

    public AppBrandLaunchReferrer aaD() {
        return this.fdD.fct.fqA;
    }
}
