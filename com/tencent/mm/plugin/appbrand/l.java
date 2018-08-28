package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.debugger.r.1;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends c {
    public volatile boolean Sx = true;
    public g fdO;
    public d fdP = aaF();
    public b fdQ = aaE();
    public o fdR;
    protected LinkedList<a> fdS = new LinkedList();
    public boolean fdT = false;
    private boolean fdU = false;
    private long fdV = System.currentTimeMillis();
    public long fdW;
    private volatile boolean fdX = false;
    public String mAppId;

    public l() {
        if (this.fdQ.y(f.class) != null && r.aaM()) {
            d dVar = new d(this, (f) this.fdQ.y(f.class));
            this.fdQ.addJavascriptInterface(dVar, "WeixinJSContext");
            dVar.aad();
            this.fdX = true;
        }
        this.fdR = new o(this);
        this.fdQ.setJsExceptionHandler(new 1(this));
        this.fdW = System.currentTimeMillis() - this.fdV;
    }

    public b aaE() {
        return h.cD(ad.getContext());
    }

    public d aaF() {
        d dVar = new d(this, this.fdQ);
        this.fdQ.addJavascriptInterface(dVar, "WeixinJSCore");
        return dVar;
    }

    public void h(g gVar) {
        x.i("MicroMsg.AppBrandService", "onRuntimeReady, mPreLoadWebView %b", new Object[]{Boolean.valueOf(this.fdT)});
        this.fdO = gVar;
        this.mAppId = gVar.mAppId;
        if (this.fdQ.y(e.class) != null) {
            ((e) this.fdQ.y(e.class)).setJsRuntimeTitle(String.format("https://servicewechat.com/%s/js-engine", new Object[]{this.mAppId}));
        }
    }

    public void init() {
        aaJ();
        aaH();
        if (!this.fdX) {
            String a = ao.a(this.fdO, "app-service.js");
            com.tencent.mm.plugin.report.service.h.mEJ.a(370, 9, 1, false);
            i.a(this.fdQ, "app-service.js", a, new 6(this));
            r.a(this.fdO, this.fdQ, "app-service.js");
            g gVar = this.fdO;
            b bVar = this.fdQ;
            if (gVar == null || bVar == null) {
                x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime is null.");
            } else if (a.jC(gVar.fcu.frm.fih)) {
                x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
            } else {
                a = WxaCommLibRuntimeReader.qJ("WASourceMap.js");
                if (a == null || a.length() == 0) {
                    x.w("MicroMsg.SourceMapInjector", "WASourceMap.js is null or nil");
                } else {
                    i.a(bVar, a, new 1());
                }
            }
        }
        aaG();
    }

    public void qw(String str) {
        if (this.fdX) {
            try {
                j("onSubPackageReady", new JSONObject().put("moduleName", str).toString(), 0);
                return;
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandService", "loadModule using isolate context, notify but get exception %s");
                return;
            }
        }
        String str2 = str + (str.endsWith("/") ? "" : "/") + "app-service.js";
        String a = ao.a(this.fdO, str2);
        com.tencent.mm.plugin.report.service.h.mEJ.a(370, 30, 1, false);
        i.a(this.fdQ, str2, a, new 2(this, str));
        r.a(this.fdO, this.fdQ, str2);
    }

    public final synchronized void aaG() {
        Iterator it = this.fdS.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            super.j(aVar.bHA, aVar.data, aVar.src);
        }
        this.fdS = null;
    }

    public final void aaH() {
        if (!this.fdU) {
            this.fdU = true;
            i.a(this.fdQ, com.tencent.mm.plugin.appbrand.q.c.vM("wxa_library/android.js"), new 3(this));
            i.a(this.fdQ, WxaCommLibRuntimeReader.qJ("WAService.js"), new i.a() {
                public final void qe(String str) {
                    x.i("MicroMsg.AppBrandService", "Inject SDK Service Script Success");
                    com.tencent.mm.plugin.report.service.h.mEJ.a(370, 7, 1, false);
                    l.this.fdQ.evaluateJavascript("(function(){return JSON.stringify(wx.version);})()", new 1(this));
                }

                public final void fM(String str) {
                    int i = 0;
                    x.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s", new Object[]{str});
                    com.tencent.mm.plugin.report.service.h.mEJ.a(370, 6, 1, false);
                    com.tencent.mm.plugin.appbrand.report.a.G(l.this.mAppId, 24, 0);
                    int i2 = -1;
                    if (l.this.fdO != null) {
                        i = l.this.fdO.fcu.frm.fii;
                        i2 = l.this.fdO.fcu.frm.fih;
                    }
                    com.tencent.mm.plugin.appbrand.report.a.a(l.this.mAppId, i, i2, 370, 6);
                }
            });
            com.tencent.mm.plugin.report.service.h.mEJ.a(370, 5, 1, false);
        }
        if (this.fdO != null) {
            String str = "";
            if (AppBrandPerformanceManager.vi(this.mAppId)) {
                str = WxaCommLibRuntimeReader.qJ("WAPerf.js");
            }
            if (bi.oW(str)) {
                x.i("MicroMsg.AppBrandService", "execInternalInitScript, performanceJs nil");
            } else {
                i.a(this.fdQ, str, new 5(this));
            }
        }
    }

    public void j(String str, String str2, int i) {
        synchronized (this) {
            if (this.fdS != null) {
                this.fdS.add(new a(str, str2, i));
                return;
            }
            super.j(str, str2, i);
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.fdO.fcz.c(str, str2, iArr);
    }

    public final boolean isRunning() {
        return this.Sx;
    }

    public final Activity getContext() {
        return this.fdO == null ? null : this.fdO.fcq;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final g getRuntime() {
        return this.fdO;
    }

    public final b aaI() {
        return this.fdQ;
    }

    public void cleanup() {
        super.cleanup();
        this.Sx = false;
        this.fdQ.destroy();
        this.fdP.cleanup();
    }

    public void aaJ() {
        JSONObject aaK = aaK();
        String str = this.fdO.fcv.foU;
        this.fdQ.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{aaK.toString(), str}), null);
        if (this.fdT) {
            super.j("onWxConfigReady", "", 0);
        }
    }

    public final JSONObject aaK() {
        JSONObject jSONObject = new JSONObject();
        AppBrandSysConfig appBrandSysConfig = this.fdO.fcu;
        com.tencent.mm.plugin.appbrand.config.a aVar = this.fdO.fcv;
        if (appBrandSysConfig == null || aVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = aVar.foT;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                jSONObject.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        a(jSONObject, "appType", Integer.valueOf(this.fdO.fct.bGM));
        a(jSONObject, "debug", Boolean.valueOf(this.fdO.fcu.fqL));
        a(jSONObject, "downloadDomain", appBrandSysConfig.frg);
        g(jSONObject);
        Object jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "scene", Integer.valueOf(this.fdO.aan()));
        String aao = this.fdO.aao();
        a((JSONObject) jSONObject3, "path", com.tencent.mm.plugin.appbrand.q.l.vP(aao));
        a((JSONObject) jSONObject3, "query", new JSONObject(com.tencent.mm.plugin.appbrand.q.l.vQ(aao)));
        a((JSONObject) jSONObject3, "topBarStatus", Boolean.valueOf(this.fdO.fct.fqy));
        a((JSONObject) jSONObject3, "referrerInfo", this.fdO.fct.fqA.aef());
        a((JSONObject) jSONObject3, "shareInfo", this.fdO.fct.aec());
        a((JSONObject) jSONObject3, "isSticky", Boolean.valueOf(this.fdO.fct.fqy));
        com.tencent.mm.plugin.appbrand.report.a.e.a(this.fdO, jSONObject3);
        Object jSONObject4 = new JSONObject();
        try {
            a((JSONObject) jSONObject4, "template", new JSONArray(appBrandSysConfig.fqK));
        } catch (Exception e2) {
        }
        a((JSONObject) jSONObject4, "maxRequestConcurrent", Integer.valueOf(appBrandSysConfig.fqT));
        a((JSONObject) jSONObject4, "maxUploadConcurrent", Integer.valueOf(appBrandSysConfig.fqU));
        a((JSONObject) jSONObject4, "maxDownloadConcurrent", Integer.valueOf(appBrandSysConfig.fqV));
        a((JSONObject) jSONObject4, "maxWebsocketConnect", Integer.valueOf(appBrandSysConfig.fqW));
        a((JSONObject) jSONObject4, "maxWorkerConcurrent", Integer.valueOf(appBrandSysConfig.fqX));
        a(jSONObject, "appLaunchInfo", jSONObject3);
        a(jSONObject, "wxAppInfo", jSONObject4);
        a(jSONObject, "isPluginMiniProgram", Boolean.valueOf(this.fdO.aap()));
        jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "USER_DATA_PATH", (Object) "wxfile://usr");
        a(jSONObject, "env", jSONObject3);
        try {
            a(jSONObject, "appContactInfo", new JSONObject(bi.aG(this.fdO.fct.fqu, "{}")));
        } catch (JSONException e3) {
            x.e("MicroMsg.AppBrandService", "generateWxConfig appID(%s) parse clientJsExtInfo(%s) failed e = %s", new Object[]{this.mAppId, r2, e3});
        }
        a(jSONObject, "accountInfo", this.fdO.fct.aed());
        try {
            jSONObject.put("envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.a.kO(this.fdO.fct.fig).name().toLowerCase());
        } catch (Exception e4) {
        }
        return f(jSONObject);
    }

    public JSONObject f(JSONObject jSONObject) {
        if (this.fdX && getClass() == l.class) {
            a(jSONObject, "isIsolateContext", Boolean.valueOf(true));
        }
        return jSONObject;
    }

    public final void g(JSONObject jSONObject) {
        a(jSONObject, "platform", (Object) "android");
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.qVN));
        a(jSONObject, "nativeBufferEnabled", Boolean.valueOf(this.fdQ.y(com.tencent.mm.plugin.appbrand.g.d.class) != null));
        a(jSONObject, "system", "Android " + VERSION.RELEASE);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandService", e.getMessage());
        }
    }
}
