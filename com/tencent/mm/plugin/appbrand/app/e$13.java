package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.sl;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class e$13 extends c<sl> {
    final /* synthetic */ e ffn;

    e$13(e eVar) {
        this.ffn = eVar;
        this.sFo = sl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        sl slVar = (sl) bVar;
        if (!bi.oW(slVar.cdl.bGy)) {
            q.aei();
            String str = slVar.cdl.bGy;
            int i = slVar.cdl.cdn;
            if (slVar.cdl.action != 1) {
                z = false;
            }
            slVar.cdm.cdo = q.h(str, i, z);
        }
        return false;
    }
}
