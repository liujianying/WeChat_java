package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.dynamic.i.a;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.c.b;
import com.tencent.mm.v.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c implements b {
    private Handler fwr;
    public a fws;

    public c() {
        HandlerThread handlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
        handlerThread.start();
        this.fwr = new Handler(handlerThread.getLooper());
    }

    public final String fN(String str) {
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[]{str});
        return H(str, "fail:not supported");
    }

    public final String a(com.tencent.mm.u.c.a aVar, com.tencent.mm.u.d.a aVar2, com.tencent.mm.u.b.b bVar, String str, com.tencent.mm.u.b.b.a aVar3) {
        String str2 = "";
        String str3 = bVar.name;
        if (aVar2.gu(bVar.index)) {
            String a;
            String bT = k.bT(System.nanoTime());
            boolean rB = d.rB(str3);
            com.tencent.mm.plugin.appbrand.collector.c.c("jsapi_draw_canvas", bT, "start_jsapi_invoke", rB);
            com.tencent.mm.plugin.appbrand.collector.c.ba(bT, "after_draw_actions");
            if (bVar instanceof b) {
                JSONObject sG = sG(str);
                if (sG == null) {
                    return H(str3, "fail:invalid data");
                }
                a = bVar.a(aVar, sG, aVar3);
            } else {
                this.fwr.post(new 1(this, bT, rB, str, aVar3, str3, bVar, aVar));
                a = str2;
            }
            if (this.fws == null) {
                return a;
            }
            this.fws.sI(str3);
            return a;
        }
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[]{str3});
        return H(str3, "fail:access denied");
    }

    public final void quit() {
        this.fwr.getLooper().quit();
        if (this.fws != null) {
            this.fws.xP();
        }
    }

    static JSONObject sG(String str) {
        try {
            if (bi.oW(str)) {
                str = "{}";
            }
            long nanoTime = System.nanoTime();
            JSONObject fU = g.fU(str);
            com.tencent.mm.plugin.appbrand.dynamic.i.b.f(System.nanoTime() - nanoTime, str.length());
            return fU;
        } catch (Throwable e) {
            x.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(e));
            return null;
        }
    }

    public final String H(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }
}
