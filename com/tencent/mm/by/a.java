package com.tencent.mm.by;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void aD(_Callback _callback);
    }

    public a() {
        super(new e());
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        Iterator it = cBB().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.byz != null) {
                    this.uQz.b(bVar.byz);
                    this.uQz.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            Void voidR = (Void) obj;
                            aVar.aD(bVar.uQB);
                            return voidR;
                        }
                    }, com.tencent.mm.vending.c.a.uQG, true);
                } else {
                    aVar.aD(bVar.uQB);
                }
            }
        }
    }

    public b<_Callback> aI(_Callback _callback) {
        return super.a(new b(_callback, this));
    }

    public final void remove(_Callback _callback) {
        super.b(new b(_callback, this));
    }
}
