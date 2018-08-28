package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.k.j$a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;
import java.util.Iterator;

public final class j implements b {
    l fcy;
    h ftb;
    String ftc;
    Activity ftd;
    o fte;
    l ftf = new l();
    q ftg;
    j$a fth = new 2(this);

    public j() {
        a.sFg.a(new 4(this));
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.ftb.aex()) {
            if (this.ftb.hv()) {
                cbi cbi = new cbi();
                cbi.sxA = this.ftb.fsI.incrementAndGet();
                cbi.script = str;
                this.ftf.a(p.a(cbi, this.ftb, "evaluateJavascript"));
                int i = cbi.sxA;
                a aVar = new a();
                if (bi.oW(this.ftc)) {
                    aVar.bHA = m.so(str);
                } else {
                    aVar.bHA = this.ftc;
                    this.ftc = null;
                }
                aVar.fsv = System.currentTimeMillis();
                aVar.size = str.length();
                aVar.fsu = valueCallback;
                this.ftb.fsR.put(Integer.valueOf(i), aVar);
                return;
            }
            this.ftb.fsN.add(new Pair(str, valueCallback));
            this.ftc = null;
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void setJsExceptionHandler(d dVar) {
    }

    public final void destroy() {
        if (this.fcy.fEH) {
            p.ftI = this.ftb;
            this.fte.sp("destroy");
        } else {
            this.ftf.quit();
        }
        this.ftf.aeF();
    }

    public final <T extends c> T y(Class<T> cls) {
        return null;
    }

    final void connect() {
        if (this.fte == null) {
            this.fte = new o(this.fcy.mAppId);
            l lVar = this.ftf;
            o oVar = this.fte;
            h hVar = this.ftb;
            Context context = this.ftd;
            com.tencent.mm.plugin.appbrand.jsapi.d dVar = this.fcy.fdP;
            q qVar = this.ftg;
            lVar.fte = oVar;
            lVar.ftb = hVar;
            lVar.mContext = context;
            lVar.fdP = dVar;
            lVar.ftg = qVar;
        }
        if (this.ftb.aez()) {
            this.fte.a("ws://localhost:" + this.ftb.fsC.fsZ, this.fth);
        } else {
            this.fte.a("wss://wxagame.weixin.qq.com/remote/", this.fth);
        }
    }

    final void onReady() {
        x.i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.ftb.setStatus(3);
        x.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.ftb.fsN.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.ftb.fsN.clear();
        this.ftf.bF(this.ftb.aev(), Integer.MAX_VALUE);
        this.ftg.aeN();
    }

    public final void a(k kVar) {
        this.ftf.a(kVar);
    }
}
