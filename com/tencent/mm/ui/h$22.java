package com.tencent.mm.ui;

import com.tencent.mm.g.a.ph;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.b.b;

class h$22 extends a {
    final /* synthetic */ h tiG;

    h$22(h hVar) {
        this.tiG = hVar;
    }

    public final void j(b bVar) {
        if (bVar instanceof ph) {
            h.g(this.tiG);
            h.a(this.tiG).notifyDataSetChanged();
        }
    }
}
