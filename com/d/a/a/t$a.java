package com.d.a.a;

import com.d.a.a.n.a;
import com.d.a.a.s.e;
import com.d.a.a.s.g;
import com.d.a.a.t.b;
import com.d.a.a.t.c;
import com.d.a.a.t.d;

class t$a implements m {
    private t$a() {
    }

    /* synthetic */ t$a(byte b) {
        this();
    }

    public final void a(p pVar) {
        c cVar;
        switch (pVar.what) {
            case 8901:
                if (t.sS() != null) {
                    cVar = (c) t.sS().get();
                    if (cVar != null) {
                        cVar.onRefAdded(((e) pVar).bkq);
                        return;
                    }
                    return;
                }
                return;
            case 8902:
                if (t.sS() != null) {
                    cVar = (c) t.sS().get();
                    if (cVar != null) {
                        cVar.onTrackProcessed(((g) pVar).bkr);
                        return;
                    }
                    return;
                }
                return;
            case 9901:
                if (t.sQ() != null) {
                    b bVar = (b) t.sQ().get();
                    if (bVar != null) {
                        a aVar = (a) pVar;
                        bVar.onLocationUpdate(aVar.lat, aVar.lng, aVar.bji, aVar.bjj, aVar.bjk);
                        return;
                    }
                    return;
                }
                return;
            case 9902:
                if (t.sR() != null) {
                    d dVar = (d) t.sR().get();
                    if (dVar != null) {
                        n.b bVar2 = (n.b) pVar;
                        dVar.onMessage(bVar2.code, bVar2.message);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
