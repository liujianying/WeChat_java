package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.ac.z;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.c;

class f$1 implements c {
    final /* synthetic */ f hrU;

    f$1(f fVar) {
        this.hrU = fVar;
    }

    public final void a(a aVar) {
        f.a(this.hrU).clear();
        f.a(this.hrU).addAll(z.Nf().ckI());
        this.hrU.notifyDataSetChanged();
    }
}
