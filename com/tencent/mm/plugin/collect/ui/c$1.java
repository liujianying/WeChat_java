package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.aa.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ long hWz;
    final /* synthetic */ c hZc;

    c$1(c cVar, long j) {
        this.hZc = cVar;
        this.hWz = j;
    }

    public final void x(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bi.VF() - this.hWz) + " ms");
            c.J(str, 3);
            q.KJ().jO(str);
        } else {
            x.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
        }
        b.a(c.a(this.hZc), c.b(this.hZc));
    }
}
