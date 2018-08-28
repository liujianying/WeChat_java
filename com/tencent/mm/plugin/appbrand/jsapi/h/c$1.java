package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.c.a;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ long fWe;
    final /* synthetic */ String fWf;
    final /* synthetic */ c fWg;

    c$1(c cVar, long j, l lVar, String str) {
        this.fWg = cVar;
        this.fWe = j;
        this.fCl = lVar;
        this.fWf = str;
    }

    public final void tR(String str) {
        int i;
        String str2 = "MicroMsg.JsApiCreateRequestTask";
        String str3 = "onRequestResult, time: %d, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - this.fWe);
        if (str == null) {
            i = 0;
        } else {
            i = str.length();
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str2, str3, objArr);
        c uL = e.alu().uL(this.fCl.mAppId);
        if (uL == null || !uL.uG(this.fWf)) {
            c.c(this.fCl, this.fWf, str);
            AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(this.fCl.mAppId);
            if (qb != null) {
                f.sw(bi.oV(qb.bGG));
                return;
            }
            return;
        }
        x.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", new Object[]{this.fWf});
    }

    public final void a(String str, Object obj, int i, JSONObject jSONObject) {
        int length;
        if (obj != null && (obj instanceof ByteBuffer)) {
            length = ((ByteBuffer) obj).array().length;
        } else if (obj == null || !(obj instanceof String)) {
            length = 0;
        } else {
            length = ((String) obj).length();
        }
        x.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.fWe), Integer.valueOf(length), Integer.valueOf(i), this.fWf});
        Map hashMap = new HashMap();
        hashMap.put("requestTaskId", this.fWf);
        if (str.equalsIgnoreCase("ok")) {
            hashMap.put("state", "success");
            hashMap.put("data", obj);
        } else {
            hashMap.put("state", "fail");
        }
        hashMap.put("statusCode", Integer.valueOf(i));
        if (jSONObject != null) {
            hashMap.put("header", jSONObject);
        }
        c.a aVar = new c.a();
        if ((obj != null && (obj instanceof String)) || m.a(this.fCl, hashMap, aVar)) {
            String jSONObject2 = new JSONObject(hashMap).toString();
            h a = aVar.a(this.fCl);
            a.mData = jSONObject2;
            a.ahM();
        }
    }

    public final void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                Map hashMap = new HashMap();
                hashMap.put("requestTaskId", this.fWf);
                hashMap.put("state", "headersReceived");
                hashMap.put("header", jSONObject);
                c.a aVar = new c.a();
                String jSONObject2 = new JSONObject(hashMap).toString();
                h a = aVar.a(this.fCl);
                a.mData = jSONObject2;
                a.ahM();
            } else if (this.fCl.fdO.aar()) {
                jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                com.tencent.mm.g.a.m mVar = new com.tencent.mm.g.a.m();
                mVar.bGA.bGB = "request";
                mVar.bGA.bGD = jSONObject;
                mVar.bGA.bGC = this.fWf;
                com.tencent.mm.sdk.b.a.sFg.m(mVar);
            }
        }
    }
}
