package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.file.ae;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class b$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ l fCl;
    private JSONObject fWa;
    final /* synthetic */ String fWb;
    final /* synthetic */ String fWc;
    final /* synthetic */ b fWd;

    b$1(b bVar, String str, l lVar, String str2, String str3) {
        this.fWd = bVar;
        this.fWb = str;
        this.fCl = lVar;
        this.fWc = str2;
        this.bAj = str3;
    }

    public final void c(int i, String str, String str2, int i2) {
        x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        String jSONObject;
        h a;
        if (bi.oW(this.fWb)) {
            if (com.tencent.mm.plugin.appbrand.k.a.FAILED != i) {
                AppBrandLocalMediaObject D = b.D(this.bAj, str2, str);
                if (D != null) {
                    x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode localId %s", D.bNH);
                    Map hashMap = new HashMap();
                    hashMap.put("downloadTaskId", this.fWc);
                    hashMap.put("tempFilePath", D.bNH);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("state", "success");
                    if (this.fWa != null) {
                        hashMap.put("header", this.fWa);
                    }
                    jSONObject = new JSONObject(hashMap).toString();
                    a = new b.a().a(this.fCl);
                    a.mData = jSONObject;
                    a.ahM();
                    return;
                }
            }
            if (!b.a(this.fCl, this.fWc)) {
                b.b(this.fCl, this.fWc, "download fail");
                return;
            }
            return;
        }
        jSONObject = ae.a(this.fCl.fdO, str2, this.fWb);
        if (com.tencent.mm.plugin.appbrand.k.a.FAILED != i && "ok".equals(jSONObject)) {
            x.i("MicroMsg.JsApiCreateDownloadTask", "onDownloadResultWithCode filePath %s", this.fWb);
            Map hashMap2 = new HashMap();
            hashMap2.put("downloadTaskId", this.fWc);
            hashMap2.put("filePath", this.fWb);
            hashMap2.put("statusCode", Integer.valueOf(i2));
            hashMap2.put("state", "success");
            if (this.fWa != null) {
                hashMap2.put("header", this.fWa);
            }
            jSONObject = new JSONObject(hashMap2).toString();
            a = new b.a().a(this.fCl);
            a.mData = jSONObject;
            a.ahM();
        } else if (!b.a(this.fCl, this.fWc)) {
            b.b(this.fCl, this.fWc, jSONObject);
        }
    }

    public final void e(int i, long j, long j2) {
        Map hashMap = new HashMap();
        hashMap.put("downloadTaskId", this.fWc);
        hashMap.put("state", "progressUpdate");
        hashMap.put("progress", Integer.valueOf(i));
        hashMap.put("totalBytesWritten", Long.valueOf(j));
        hashMap.put("totalBytesExpectedToWrite", Long.valueOf(j2));
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new b.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void tQ(String str) {
        if (!b.a(this.fCl, this.fWc)) {
            b.b(this.fCl, this.fWc, str);
        }
    }

    public final void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                this.fWa = jSONObject;
                Map hashMap = new HashMap();
                hashMap.put("downloadTaskId", this.fWc);
                hashMap.put("state", "headersReceived");
                hashMap.put("header", this.fWa);
                String jSONObject2 = new JSONObject(hashMap).toString();
                h a = new b.a().a(this.fCl);
                a.mData = jSONObject2;
                a.ahM();
            } else if (this.fCl.fdO.aar()) {
                jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                m mVar = new m();
                mVar.bGA.bGB = "download";
                mVar.bGA.bGD = jSONObject;
                mVar.bGA.bGC = this.fWc;
                com.tencent.mm.sdk.b.a.sFg.m(mVar);
            }
        }
    }
}
