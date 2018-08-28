package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.ja;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$11 extends c<ja> {
    final /* synthetic */ e ffn;

    e$11(e eVar) {
        this.ffn = eVar;
        this.sFo = ja.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((ja) bVar).bSG.aAk) {
            case 1:
            case 3:
                e.lE(1);
                break;
            default:
                e.lE(0);
                break;
        }
        com.tencent.mm.plugin.appbrand.dynamic.h.b.afv();
        return true;
    }
}
