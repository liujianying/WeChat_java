package com.tencent.mm.d;

import android.graphics.Rect;
import com.tencent.mm.t.a;
import com.tencent.mm.view.b.a.b;

class c$2 implements b {
    final /* synthetic */ c bCc;

    c$2(c cVar) {
        this.bCc = cVar;
    }

    public final void vU() {
        this.bCc.bBQ = true;
        this.bCc.bBn.cfQ().getBaseBoardView().m(new Rect(0, 0, this.bCc.bBn.cfS().getWidth(), this.bCc.bBn.cfS().getHeight()));
        c.a(this.bCc, 200, true, false);
    }

    public final void onStart() {
        c.a(this.bCc, false);
        this.bCc.bBQ = false;
        c.a(this.bCc);
        a.gt(282);
    }
}
