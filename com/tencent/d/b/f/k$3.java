package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;

class k$3 implements b<e.b> {
    final /* synthetic */ k vng;
    final /* synthetic */ h vnh;

    k$3(k kVar, h hVar) {
        this.vng = kVar;
        this.vnh = hVar;
    }

    public final /* synthetic */ void cG(Object obj) {
        e.b bVar = (e.b) obj;
        k.dC(this.vng.vlV, 0);
        c.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", new Object[]{Boolean.valueOf(bVar.vme)});
        if (bVar.vme) {
            this.vng.b(new com.tencent.d.b.a.c(this.vnh));
            return;
        }
        a.bD(this.vng.vlV, false);
        this.vng.b(new com.tencent.d.b.a.c(10, String.format("upload auth key: %s failed", new Object[]{this.vng.vlV})));
    }
}
