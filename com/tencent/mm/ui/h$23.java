package com.tencent.mm.ui;

import com.tencent.mm.g.a.pg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class h$23 extends c<pg> {
    final /* synthetic */ h tiG;

    h$23(h hVar) {
        this.tiG = hVar;
        this.sFo = pg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((pg) bVar) instanceof pg) {
            h.g(this.tiG);
            h.a(this.tiG).notifyDataSetChanged();
        }
        return false;
    }
}
