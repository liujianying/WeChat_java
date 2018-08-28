package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void cBC() {
        a(null);
    }

    public final synchronized void a(final a aVar) {
        Iterator it = cBB().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.byz != null) {
                    this.uQz.b(bVar.byz);
                } else {
                    this.uQz.b(d.cBM());
                }
                this.uQz.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        Void voidR = (Void) obj;
                        c.this.a(bVar.uQB, aVar);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.uQG, true);
            }
        }
    }

    public final b<_Callback> aI(_Callback _callback) {
        return a(new b(_callback, this));
    }
}
