package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.d;
import com.tencent.mm.u.c.f;
import com.tencent.mm.u.d.a;
import com.tencent.xweb.g;
import org.json.JSONObject;

public class e {
    private static volatile com.tencent.mm.u.c.e fxv;
    private static volatile DebuggerInfo fxw;
    private static volatile boolean fxx;

    public static com.tencent.mm.u.c.e a(Context context, final WxaWidgetContext wxaWidgetContext, a aVar, Bundle bundle) {
        com.tencent.mm.u.c.e eVar;
        String convertStreamToString;
        synchronized (e.class) {
            eVar = fxv;
            fxv = null;
        }
        if (eVar == null) {
            eVar = a(wxaWidgetContext.afc());
        }
        int i = bundle.getInt("widget_type");
        c cVar = new c();
        if (i == 1) {
            cVar.fws = new com.tencent.mm.plugin.appbrand.dynamic.i.c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        com.tencent.mm.u.c.c cVar2 = new com.tencent.mm.u.c.c(context, eVar, aVar, cVar);
        cVar2.doN = p.kc(i);
        eVar.doV = cVar2;
        d dVar = eVar.doX;
        eVar.doW = new f(dVar, com.tencent.mm.plugin.appbrand.dynamic.f.a.kd(i), aVar);
        eVar.doZ = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.afi();
        WidgetRuntimeConfig afe = wxaWidgetContext.afe();
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, "widgetType", Integer.valueOf(afe.fwV));
        b(jSONObject, "platform", "android");
        b(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.afc().fvD));
        b(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.afd().fpQ));
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.qVN));
        JSONObject jSONObject2 = new JSONObject();
        b(jSONObject2, "drawMinInterval", Integer.valueOf(afe.fxl));
        b(jSONObject2, "timerEnabled", Boolean.valueOf(afe.fxm));
        b(jSONObject2, "drawLock", Boolean.valueOf(afe.fxn));
        dVar.evaluateJavascript(String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[]{jSONObject2.toString(), jSONObject.toString(), ""}), null);
        x.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[]{wxaWidgetContext.getId(), r1});
        String bj = com.tencent.mm.plugin.appbrand.dynamic.j.c.bj(wxaWidgetContext.getId(), "WAWidget.js");
        if (bi.oW(bj)) {
            convertStreamToString = com.tencent.mm.plugin.appbrand.q.c.convertStreamToString(af.openRead("WAWidget.js"));
        } else {
            convertStreamToString = bj;
        }
        if (bi.oW(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        h.mEJ.a(636, 0, 1, false);
        com.tencent.mm.u.a.a(dVar, convertStreamToString, new com.tencent.mm.u.a.a() {
            public final void CT() {
                h.mEJ.a(636, 1, 1, false);
            }

            public final void fM(String str) {
                j.aeV().C(wxaWidgetContext.getId(), 626, 26);
                h.mEJ.a(636, 2, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[]{str});
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[]{wxaWidgetContext.getId()});
        convertStreamToString = com.tencent.mm.plugin.appbrand.dynamic.j.c.bj(wxaWidgetContext.getId(), "widget.js");
        if (bi.oW(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.aeS().ax(wxaWidgetContext.getId(), 2102);
        }
        h.mEJ.a(636, 3, 1, false);
        com.tencent.mm.u.a.a(dVar, convertStreamToString, new com.tencent.mm.u.a.a() {
            public final void CT() {
                h.mEJ.a(636, 4, 1, false);
            }

            public final void fM(String str) {
                h.mEJ.a(636, 5, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[]{str});
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[]{wxaWidgetContext.getId()});
        cv(context);
        return eVar;
    }

    public static void cv(Context context) {
        if (fxx) {
            com.tencent.mm.bu.a.ab(new 1(context));
        }
    }

    private static com.tencent.mm.u.c.e a(DebuggerInfo debuggerInfo) {
        d dVar;
        com.tencent.mm.u.c.e eVar = new com.tencent.mm.u.c.e();
        Object obj = null;
        if (debuggerInfo != null && debuggerInfo.fvE) {
            x.i("MicroMsg.PreloadOptimizer", "debug mode opened, use WebView  JavaScript Engine.");
            obj = 1;
        }
        Context context = ad.getContext();
        String str = "WeixinJSCore";
        String str2 = "https://servicewechat.com/app-widget";
        if (obj != null) {
            dVar = new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        } else {
            g a = g.a(g.a.vAc, "support", context);
            dVar = a.isValid() ? new com.tencent.mm.plugin.appbrand.dynamic.e.a(eVar, str, a) : new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        }
        if (dVar.CZ()) {
            h.mEJ.a(639, 1, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using WebView Based Javascript Engine");
        } else {
            h.mEJ.a(639, 2, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        }
        h.mEJ.a(639, 0, 1, false);
        if (eVar.doX != null) {
            x.e("MicroMsg.MiniJsBridge", "can not initialize again.");
        } else {
            eVar.doX = dVar;
        }
        return eVar;
    }

    private static void b(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[]{e});
        }
    }
}
