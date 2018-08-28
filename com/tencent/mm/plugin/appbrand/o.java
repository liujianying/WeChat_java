package com.tencent.mm.plugin.appbrand;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.f.6;
import com.tencent.mm.plugin.appbrand.g.a.h;
import com.tencent.mm.plugin.appbrand.g.a.i;
import com.tencent.mm.plugin.appbrand.g.a.i.3;
import com.tencent.mm.plugin.appbrand.g.a.j;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    l fcy;
    d fec;
    public i fed;
    private j fef = new 1(this);

    public o(l lVar) {
        this.fcy = lVar;
        this.fec = (d) lVar.fdQ.y(d.class);
        this.fed = new i(this.fef);
        lVar.fdQ.addJavascriptInterface(this, "WeixinWorker");
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int create(String str) {
        Pair pair;
        String vM = c.vM("wxa_library/bootstrap_j2v8_worker.js");
        String format = String.format("var __wxConfig = %s;", new Object[]{this.fcy.aaK().toString()});
        String qJ = WxaCommLibRuntimeReader.qJ("WAWorker.js");
        String a = ao.a(this.fcy.fdO, str);
        if ((!a.jC(this.fcy.fdO.fcu.frm.fih) ? 1 : 0) != 0) {
            String a2 = ao.a(this.fcy.fdO, str + ".map");
            if (a2 != null && a2.length() > 0) {
                pair = new Pair(null, a2);
                x.i("MicroMsg.AppBrandWorkerContainer", "injectSourceMap(%s.map)", new Object[]{str});
                return this.fed.a(new Pair[]{new Pair(null, vM), new Pair(null, format), new Pair(null, qJ), new Pair(r.st(str), a), pair});
            }
        }
        pair = null;
        return this.fed.a(new Pair[]{new Pair(null, vM), new Pair(null, format), new Pair(null, qJ), new Pair(r.st(str), a), pair});
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void terminate(int i) {
        f fVar = (f) this.fed.geA.remove(Integer.valueOf(i));
        if (fVar != null) {
            fVar.gem.r(new 6(fVar));
            h hVar = fVar.gem;
            synchronized (hVar.gek) {
                hVar.Sx = false;
            }
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void postMsgToWorker(int i, String str) {
        i iVar = this.fed;
        f fVar = (f) iVar.geA.get(Integer.valueOf(i));
        if (fVar != null) {
            fVar.gem.r(new 3(iVar, fVar, str));
        }
    }
}
