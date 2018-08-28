package com.tencent.mm.plugin.appbrand.game;

import android.graphics.Point;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends l implements h {
    private b fdQ;
    private l fzQ;
    private long fzR;
    private long fzS;
    private long fzT;

    static /* synthetic */ void g(d dVar) {
        dVar.fzT = System.currentTimeMillis();
        String a = a.a(dVar.fdO, "game.js", false);
        h.mEJ.a(778, 25, 1, false);
        x.i("MicroMsg.WAGameAppService", "Inject jsMainContext game.js");
        i.a(dVar.fdQ, "game.js", a, new 5(dVar));
        r.a(dVar.fdO, dVar.fdQ, "game.js");
    }

    protected final b aaE() {
        this.fdQ = new g(this);
        this.fzQ = new l(this, this.fdQ);
        return this.fdQ;
    }

    protected final com.tencent.mm.plugin.appbrand.jsapi.d aaF() {
        com.tencent.mm.plugin.appbrand.jsapi.d dVar = new com.tencent.mm.plugin.appbrand.jsapi.d(this, this.fdQ);
        this.fdQ.addJavascriptInterface(dVar, "WeixinJSCore");
        return dVar;
    }

    public final void init() {
        x.i("MicroMsg.WAGameAppService", "WAGameAppService.init");
        if (this.fdO != null) {
            this.fdO.fcJ.o(7, this.fdW);
        }
        e(new 1(this));
    }

    private boolean afU() {
        return this.fzQ != null && this.fzQ.agn();
    }

    public final void cleanup() {
        super.cleanup();
    }

    protected final JSONObject f(JSONObject jSONObject) {
        JSONObject jSONObject2;
        super.f(jSONObject);
        AppBrandSysConfig appBrandSysConfig = this.fdO.fcu;
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.optJSONObject("wxAppInfo");
        } catch (Exception e) {
        }
        if (jSONObject3 == null) {
            jSONObject2 = new JSONObject();
        } else {
            jSONObject2 = jSONObject3;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object put : appBrandSysConfig.frn.fpV) {
                jSONArray.put(put);
            }
            a(jSONObject2, "subContextImgDomain", jSONArray);
        } catch (Exception e2) {
        }
        a(jSONObject, "wxAppInfo", jSONObject2);
        Point point = new Point();
        m.fAw.d(point);
        float density = a.getDensity(getContext());
        x.i("MicroMsg.WAGameAppService", "dm.widthPixels %d, dm.heightPixels %d", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y)});
        if (com.tencent.mm.plugin.appbrand.config.d.p(this.fdO)) {
            x.i("MicroMsg.WAGameAppService", "screen in right orientation");
            a(jSONObject, "screenWidth", Float.valueOf(((float) point.x) / density));
            a(jSONObject, "screenHeight", Float.valueOf(((float) point.y) / density));
        } else {
            x.w("MicroMsg.WAGameAppService", "screen in reverse orientation");
            a(jSONObject, "screenWidth", Float.valueOf(((float) point.y) / density));
            a(jSONObject, "screenHeight", Float.valueOf(((float) point.x) / density));
        }
        a(jSONObject, "devicePixelRatio", Float.valueOf(density));
        if (afU()) {
            a(jSONObject, "isIsolateContext", Boolean.valueOf(true));
        }
        return jSONObject;
    }

    public final void E(int i, String str) {
        if (this.Sx) {
            e(new 2(this, i, str));
        }
    }

    public final void j(String str, String str2, int i) {
        if (this.Sx) {
            e(new 3(this, str, str2, i));
        }
    }

    private void e(Runnable runnable) {
        c cVar;
        p currentPageView = this.fdO.fcz.getCurrentPage().getCurrentPageView();
        if (currentPageView instanceof c) {
            cVar = (c) currentPageView;
        } else {
            x.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
            cVar = null;
        }
        if (cVar != null) {
            cVar.e(runnable);
        } else {
            x.e("MicroMsg.WAGameAppService", "runOnRenderThread can't find the IRenderThreadHandler");
        }
    }

    public final void qw(String str) {
        x.i("MicroMsg.WAGameAppService", "hy: do nothing in game service when called from modularizing helper");
    }
}
