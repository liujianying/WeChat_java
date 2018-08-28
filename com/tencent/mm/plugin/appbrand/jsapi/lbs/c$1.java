package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class c$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ c fQW;

    c$1(c cVar, l lVar) {
        this.fQW = cVar;
        this.fCl = lVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            if (intent == null) {
                this.fCl.E(this.fQW.fFw, this.fQW.f("fail", null));
                x.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                return;
            }
            Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
            Map hashMap = new HashMap();
            if (addr != null) {
                x.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                StringBuilder stringBuilder = new StringBuilder();
                if (TextUtils.isEmpty(addr.dRH)) {
                    stringBuilder.append(addr.Oy());
                } else {
                    stringBuilder.append(addr.dRH);
                }
                hashMap.put("address", stringBuilder.toString());
                if (TextUtils.isEmpty(addr.dRQ)) {
                    hashMap.put("name", stringBuilder.toString());
                } else {
                    hashMap.put("name", addr.dRQ);
                }
                hashMap.put("latitude", Float.valueOf(addr.dRS));
                hashMap.put("longitude", Float.valueOf(addr.dRT));
                this.fCl.E(this.fQW.fFw, this.fQW.f("ok", hashMap));
                return;
            }
            this.fCl.E(this.fQW.fFw, this.fQW.f("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
        } else if (i2 == 0) {
            this.fCl.E(this.fQW.fFw, this.fQW.f("cancel", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
        } else {
            this.fCl.E(this.fQW.fFw, this.fQW.f("fail", null));
            x.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
        }
    }
}
