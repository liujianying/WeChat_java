package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.j.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    boolean Sx;
    final c fEJ;
    private final b fEK;
    private final Map<String, e> fEL;
    private int fEM;
    private ConcurrentHashMap<Integer, String> fEN;
    public Handler fwr;

    public d(l lVar, b bVar) {
        this(lVar, bVar, i.ahN());
    }

    public d(p pVar, b bVar) {
        this(pVar, bVar, i.ahO());
    }

    public d(com.tencent.mm.plugin.appbrand.game.d dVar, b bVar) {
        this(dVar, bVar, c.agz());
    }

    private d(c cVar, b bVar, Map<String, e> map) {
        this.fEM = 0;
        this.fEN = new ConcurrentHashMap();
        this.fEJ = cVar;
        this.fEK = bVar;
        this.Sx = true;
        this.fEL = map;
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.fwr = new Handler(handlerThread.getLooper());
    }

    public final void cleanup() {
        this.fwr.getLooper().quit();
        this.Sx = false;
        this.fEN.clear();
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        this.fwr.post(new 1(this, str, str2, str3));
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "publishHandler, event: %s, data size: %d, data : %s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = str2;
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        try {
            int a = this.fEJ.a(this.fEK, i);
            e eVar = (e) this.fEL.get(str);
            if (eVar == null) {
                this.fEJ.E(a, H(str, "fail:not supported"));
                return "fail:not supported";
            }
            String str4;
            String a2;
            boolean z = eVar instanceof n;
            j jVar = this.fEJ.fEE;
            c cVar = this.fEJ;
            if (this.fEJ.getRuntime() == null) {
                str4 = "";
            } else {
                n nVar = this.fEJ.getRuntime().fcz;
                str4 = (nVar == null || nVar.getCurrentPage() == null) ? "" : nVar.getCurrentPage().getCurrentUrl();
            }
            if (!h.adV(eVar.getName())) {
                jVar.fFi.put(Integer.valueOf(a), new a(cVar, eVar, str2, System.currentTimeMillis(), str4));
            }
            if (z) {
                a2 = a(str, str2, a, true);
            } else {
                this.fwr.post(new 2(this, str, str2, a));
                a2 = str3;
            }
            if ((!com.tencent.mm.compatible.loader.a.a(o.fFq, eVar.getClass()) ? 1 : null) == null) {
                return a2;
            }
            int i2;
            String str5 = "MicroMsg.AppBrandJSInterface";
            String str6 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                i2 = 0;
            } else {
                i2 = str2.length();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            x.i(str5, str6, objArr);
            return a2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, " Invoke Error %s", new Object[]{str});
            throw e;
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String retrieveEvent(int i) {
        String str = (String) this.fEN.get(Integer.valueOf(i));
        this.fEN.remove(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final boolean isDebugPackage() {
        return com.tencent.mm.sdk.a.b.chp();
    }

    private String a(String str, String str2, int i, boolean z) {
        if (this.fEJ.getRuntime() == null || !this.fEJ.isRunning()) {
            return H(str, "fail:interrupted");
        }
        e eVar = (e) this.fEL.get(str);
        com.tencent.mm.plugin.appbrand.permission.c.a a = com.tencent.mm.plugin.appbrand.permission.c.u(this.fEJ.getRuntime()).a(this.fEJ, eVar, new 3(this, str, str2, i, z, eVar));
        if (3 == a.code) {
            return "";
        }
        String f;
        if (a.code != 1) {
            f = eVar.f(a.bIr, null);
        } else {
            JSONObject ti = ti(str2);
            if (ti == null) {
                f = eVar.f("fail:invalid data", null);
            } else if (z) {
                f = ((n) eVar).a(this.fEJ, ti);
            } else {
                ((a) eVar).a(this.fEJ, ti, i);
                f = null;
            }
        }
        if (f != null) {
            this.fEJ.fEE.H(i, f);
        }
        if (!z) {
            if (f != null) {
                this.fEJ.E(i, f);
            }
            return "";
        } else if (bi.oW(f)) {
            return "{}";
        } else {
            return f;
        }
    }

    private static JSONObject ti(String str) {
        try {
            if (bi.oW(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return null;
        }
    }

    private static String H(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    static int[] tj(String str) {
        int i = 0;
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
        }
        return iArr;
    }
}
