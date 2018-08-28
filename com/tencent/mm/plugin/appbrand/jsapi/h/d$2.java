package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.g.a.m;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.b.3;
import com.tencent.mm.plugin.appbrand.k.j.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class d$2 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ String fEg;
    final /* synthetic */ d fWi;
    boolean fWj = false;
    final /* synthetic */ b.a fWk;

    d$2(d dVar, l lVar, b.a aVar, String str) {
        this.fWi = dVar;
        this.fCl = lVar;
        this.fWk = aVar;
        this.fEg = str;
    }

    public final void a(h hVar) {
        this.fCl.fdO.fcL.a(this.fWk);
        Map hashMap = new HashMap();
        hashMap.put("socketTaskId", this.fEg);
        hashMap.put("state", "open");
        hashMap.put("header", d.b(hVar));
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.h a = new d.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void a(com.tencent.mm.plugin.appbrand.s.e.a aVar) {
        if (aVar != null && this.fCl.fdO.aar()) {
            m mVar = new m();
            mVar.bGA.bGB = "socket";
            mVar.bGA.bGD = d.b(aVar);
            mVar.bGA.bGC = this.fEg;
            com.tencent.mm.sdk.b.a.sFg.m(mVar);
        }
    }

    public final void sl(String str) {
        if (this.fWj) {
            x.i("MicroMsg.JsApiCreateSocketTask", "onSocketError is true");
            return;
        }
        this.fWj = true;
        Map hashMap = new HashMap();
        hashMap.put("socketTaskId", this.fEg);
        hashMap.put("state", "error");
        hashMap.put("errMsg", str);
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.h a = new d.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void sm(String str) {
        Map hashMap = new HashMap();
        hashMap.put("data", c.vT(str));
        hashMap.put("isBuffer", Boolean.valueOf(false));
        hashMap.put("socketTaskId", this.fEg);
        hashMap.put("state", "message");
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.h a = new d.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void f(ByteBuffer byteBuffer) {
        Map hashMap = new HashMap();
        hashMap.put("socketTaskId", this.fEg);
        hashMap.put("data", byteBuffer);
        hashMap.put("isBuffer", Boolean.valueOf(true));
        hashMap.put("state", "message");
        if (com.tencent.mm.plugin.appbrand.r.m.a(this.fCl, hashMap, new d.a())) {
            String jSONObject = new JSONObject(hashMap).toString();
            com.tencent.mm.plugin.appbrand.jsapi.h a = new d.a().a(this.fCl);
            a.mData = jSONObject;
            a.ahM();
        }
    }

    public final void C(int i, String str) {
        Object obj;
        b bVar = this.fCl.fdO.fcL;
        b.a aVar = this.fWk;
        if (!(aVar == null || com.tencent.mm.plugin.appbrand.b.a.fjh == bVar.fjj.acv())) {
            synchronized (bVar.fjk) {
                bVar.fjk.remove(aVar);
            }
        }
        Map hashMap = new HashMap();
        switch (3.fjn[this.fCl.fdO.fcL.fjj.acv().ordinal()]) {
            case 1:
            case 2:
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("reason", "interrupted");
        } else if (!bi.oW(str)) {
            hashMap.put("reason", str);
        }
        hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i));
        hashMap.put("socketTaskId", this.fEg);
        hashMap.put("state", "close");
        String jSONObject = new JSONObject(hashMap).toString();
        com.tencent.mm.plugin.appbrand.jsapi.h a = new d.a().a(this.fCl);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void sn(String str) {
        d.d(this.fCl, this.fEg, str);
    }
}
