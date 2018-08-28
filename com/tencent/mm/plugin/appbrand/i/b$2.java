package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.c.f;

class b$2 implements Runnable {
    final /* synthetic */ String fdZ;
    final /* synthetic */ b gkt;
    final /* synthetic */ h gku;

    b$2(b bVar, String str, h hVar) {
        this.gkt = bVar;
        this.fdZ = str;
        this.gku = hVar;
    }

    public final void run() {
        1 1 = new 1(this);
        f fVar = new f(this.gkt.fdD.fcq);
        fVar.setMessage(this.gkt.fdD.fcq.getString(j.app_brand_module_load_tips));
        fVar.setOnCancelListener(1);
        fVar.setCanceledOnTouchOutside(false);
        this.gku.value = fVar;
        this.gkt.fdD.a(fVar);
    }
}
