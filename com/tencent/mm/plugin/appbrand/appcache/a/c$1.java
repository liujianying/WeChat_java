package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class c$1 implements a<Void, String> {
    final /* synthetic */ c fiD;

    c$1(c cVar) {
        this.fiD = cVar;
    }

    private static Void qZ(String str) {
        try {
            c.qY(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", e, "process pbBase64", new Object[0]);
        }
        return null;
    }
}
