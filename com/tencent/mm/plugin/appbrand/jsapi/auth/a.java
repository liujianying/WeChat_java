package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a extends f<a> implements b {
    private static final Map<String, a> fJl = new android.support.v4.e.a();
    private static final a fJm = new 1();

    /* synthetic */ a() {
        this(null);
    }

    public static a r(g gVar) {
        if (gVar == null || gVar.mFinished) {
            return fJm;
        }
        a aVar;
        synchronized (fJl) {
            aVar = (a) fJl.get(gVar.mAppId);
            if (aVar == null) {
                aVar = new a(gVar);
                fJl.put(gVar.mAppId, aVar);
            }
        }
        return aVar;
    }

    private a(g gVar) {
        super("MicroMsg.AppBrandAuthJsApiQueue" + (gVar == null ? "|DUMMY" : "|" + gVar.mAppId), c.Em().lnJ.getLooper());
        if (gVar != null) {
            String str = gVar.mAppId;
            e.a(str, new 2(this, str));
        }
    }

    public final void aia() {
        Dd(2);
    }

    /* renamed from: aib */
    protected boolean aic() {
        return false;
    }

    /* renamed from: a */
    protected final void bk(a aVar) {
        x.d(this.mName, "about to executeTask %s", new Object[]{aVar.toString()});
        aVar.Yz();
    }
}
