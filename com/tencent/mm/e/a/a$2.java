package com.tencent.mm.e.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.modelvoice.d$b;
import com.tencent.mm.sdk.platformtools.ah;

class a$2 implements d$b {
    final /* synthetic */ a bCV;

    a$2(a aVar) {
        this.bCV = aVar;
    }

    public final void onError() {
        f.yz().b(this.bCV);
        if (a.b(this.bCV)) {
            f.yz().yC();
            a.c(this.bCV);
        }
        f.yz().setMode(0);
        if (a.d(this.bCV) != null) {
            ah.A(new 1(this));
        }
    }
}
