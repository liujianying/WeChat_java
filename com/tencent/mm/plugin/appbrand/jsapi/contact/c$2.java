package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class c$2 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ c fPu;

    c$2(c cVar, l lVar, int i) {
        this.fPu = cVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(boolean z, String str, Intent intent) {
        x.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            Map hashMap = new HashMap();
            Object obj = "";
            Object hashMap2 = new HashMap();
            if (intent != null) {
                String aG = bi.aG(intent.getStringExtra("keyOutPagePath"), "");
                obj = com.tencent.mm.plugin.appbrand.q.l.vP(aG);
                hashMap2 = com.tencent.mm.plugin.appbrand.q.l.vQ(aG);
            }
            hashMap.put("path", obj);
            hashMap.put("query", hashMap2);
            x.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[]{obj, hashMap2.toString()});
            this.fCl.E(this.doP, this.fPu.f("ok", hashMap));
            return;
        }
        this.fCl.E(this.doP, this.fPu.f(str, null));
    }
}
