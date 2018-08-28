package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.f.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class e$1 implements a {
    final /* synthetic */ String ewx;
    final /* synthetic */ l fCl;
    private JSONObject fWa;
    final /* synthetic */ String fWl;
    final /* synthetic */ e fWm;

    e$1(e eVar, l lVar, String str, String str2) {
        this.fWm = eVar;
        this.fCl = lVar;
        this.fWl = str;
        this.ewx = str2;
    }

    public final void tS(String str) {
        if (!e.b(this.fCl, this.fWl)) {
            e.e(this.fCl, this.fWl, str);
        }
    }

    public final void e(int i, String str, int i2) {
        if (i == 0) {
            x.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", new Object[]{this.ewx, str, Integer.valueOf(i)});
            Map hashMap = new HashMap();
            hashMap.put("data", str);
            hashMap.put("statusCode", Integer.valueOf(i2));
            hashMap.put("uploadTaskId", this.fWl);
            hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "success");
            if (this.fWa != null) {
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.fWa);
            }
            String jSONObject = new JSONObject(hashMap).toString();
            h a = new e.a().a(this.fCl);
            a.mData = jSONObject;
            a.ahM();
        } else if (!e.b(this.fCl, this.fWl)) {
            x.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", new Object[]{this.ewx, str, Integer.valueOf(i)});
            e.e(this.fCl, this.fWl, str);
        }
    }

    public final void f(int i, long j, long j2) {
        Map hashMap = new HashMap();
        hashMap.put("uploadTaskId", this.fWl);
        hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "progressUpdate");
        hashMap.put("progress", Integer.valueOf(i));
        hashMap.put("totalBytesSent", Long.valueOf(j));
        hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new e.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__")) {
                this.fWa = jSONObject;
                Map hashMap = new HashMap();
                hashMap.put("uploadTaskId", this.fWl);
                hashMap.put(OpenSDKTool4Assistant.EXTRA_STATE, "headersReceived");
                hashMap.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, this.fWa);
                String jSONObject2 = new JSONObject(hashMap).toString();
                h a = new e.a().a(this.fCl);
                a.mData = jSONObject2;
                a.ahM();
            } else if (this.fCl.fdO.aar()) {
                jSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
                m mVar = new m();
                mVar.bGA.bGB = "upload";
                mVar.bGA.bGD = jSONObject;
                mVar.bGA.bGC = this.fWl;
                com.tencent.mm.sdk.b.a.sFg.m(mVar);
            }
        }
    }
}
