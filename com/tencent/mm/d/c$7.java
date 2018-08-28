package com.tencent.mm.d;

import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a.b;

class c$7 implements b {
    final /* synthetic */ c bCc;

    public c$7(c cVar) {
        this.bCc = cVar;
    }

    public final void vU() {
        this.bCc.getMainMatrix().set(((a) this.bCc.vG()).dak);
        this.bCc.vP();
        c.a(this.bCc, 300, false, false);
    }

    public final void onStart() {
        c.a(this.bCc, false);
    }
}
