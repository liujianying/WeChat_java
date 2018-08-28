package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class c$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ p fJO;
    final /* synthetic */ c fKE;
    final /* synthetic */ c fKI;

    c$1(c cVar, p pVar, c cVar2, int i, JSONObject jSONObject) {
        this.fKI = cVar;
        this.fJO = pVar;
        this.fKE = cVar2;
        this.doP = i;
        this.fHi = jSONObject;
    }

    public final void run() {
        int i = 0;
        if (this.fJO == null) {
            x.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
            this.fKE.E(this.doP, this.fKI.f("fail:page is null", null));
            return;
        }
        try {
            int k = this.fKI.k(this.fHi);
            View lx = this.fJO.agU().lx(k);
            if (lx == null) {
                x.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", Integer.valueOf(k));
                this.fKE.E(this.doP, this.fKI.f("fail:got 'null' when get view by the given viewId", null));
                return;
            }
            boolean a;
            c cVar = this.fKI;
            p pVar = this.fJO;
            JSONObject jSONObject = this.fHi;
            if (cVar.aii()) {
                try {
                    b E = pVar.agU().E(k, false);
                    if (E != null) {
                        jSONObject.getBoolean("disableScroll");
                        if (!E.ie("isTouching")) {
                            E.w("disableScroll", true);
                        } else if (!E.getBoolean("disableScroll", false)) {
                            E.w("disableScroll-nextState", true);
                        }
                    }
                } catch (JSONException e) {
                }
            }
            try {
                a = this.fJO.agU().a(k, c.l(this.fHi), c.m(this.fHi), c.n(this.fHi));
                String str = "MicroMsg.BaseUpdateViewJsApi";
                String str2 = "update view(parentId : %s, viewId : %d), ret : %b";
                Object[] objArr = new Object[4];
                u.b lv = this.fJO.agU().lv(k);
                if (lv != null) {
                    i = lv.gpc;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(k);
                objArr[2] = Integer.valueOf(lx.hashCode());
                objArr[3] = Boolean.valueOf(a);
                x.i(str, str2, objArr);
            } catch (JSONException e2) {
                a = true;
            }
            boolean aik = this.fKI.aik();
            if (a) {
                if (aik) {
                    a = this.fKI.a(this.fJO, k, lx, this.fHi, new f(this.fKE, this.doP));
                } else {
                    a = this.fKI.c(this.fJO, k, lx, this.fHi);
                }
            }
            if (!aik) {
                String str3;
                c cVar2 = this.fKE;
                k = this.doP;
                c cVar3 = this.fKI;
                if (a) {
                    str3 = "ok";
                } else {
                    str3 = "fail";
                }
                cVar2.E(k, cVar3.f(str3, null));
            }
        } catch (JSONException e3) {
            this.fKE.E(this.doP, this.fKI.f("fail:view id do not exist", null));
        }
    }
}
