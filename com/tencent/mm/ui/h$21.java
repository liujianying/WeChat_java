package com.tencent.mm.ui;

import com.tencent.mm.g.a.gp;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;

class h$21 extends a {
    final /* synthetic */ h tiG;

    h$21(h hVar) {
        this.tiG = hVar;
    }

    public final void j(b bVar) {
        if (bVar instanceof gp) {
            h.f(this.tiG);
            h.a(this.tiG).notifyDataSetChanged();
        }
    }
}
