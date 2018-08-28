package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.o.e;
import com.tencent.mm.ui.m;
import java.lang.ref.WeakReference;

class o$c implements m {
    private WeakReference<a> ubz;

    o$c() {
    }

    final void j(a aVar) {
        this.ubz = new WeakReference(aVar);
        ((f) aVar.O(f.class)).a(this);
    }

    public final void cpF() {
    }

    public final void cpG() {
    }

    public final void cpH() {
    }

    public final void cpI() {
    }

    public final void cpJ() {
    }

    public final void cpK() {
        x.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
        if (this.ubz != null) {
            a aVar = (a) this.ubz.get();
            if (aVar != null) {
                u.Hx().ib(e.bq(aVar));
                ((f) aVar.O(f.class)).b(this);
                ((i) g.l(i.class)).jn(e.bq(aVar));
            }
        }
    }

    public final void cpL() {
    }
}
