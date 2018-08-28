package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.u.b.b;
import com.tencent.mm.u.b.b.a;
import org.json.JSONObject;

class c$1 implements Runnable {
    final /* synthetic */ a fvZ;
    final /* synthetic */ String fwt;
    final /* synthetic */ boolean fwu;
    final /* synthetic */ String fwv;
    final /* synthetic */ String fww;
    final /* synthetic */ b fwx;
    final /* synthetic */ com.tencent.mm.u.c.a fwy;
    final /* synthetic */ c fwz;

    c$1(c cVar, String str, boolean z, String str2, a aVar, String str3, b bVar, com.tencent.mm.u.c.a aVar2) {
        this.fwz = cVar;
        this.fwt = str;
        this.fwu = z;
        this.fwv = str2;
        this.fvZ = aVar;
        this.fww = str3;
        this.fwx = bVar;
        this.fwy = aVar2;
    }

    public final void run() {
        c.c(this.fwt, "parse_json_start", this.fwu);
        JSONObject sG = c.sG(this.fwv);
        if (sG == null) {
            this.fvZ.aA(this.fwz.H(this.fww, "fail:invalid data"));
            return;
        }
        c.c(this.fwt, "parse_json_end", this.fwu);
        d.a(this.fwt, this.fwv, sG);
        this.fwx.a(this.fwy, sG, this.fvZ);
    }
}
