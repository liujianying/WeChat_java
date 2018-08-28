package com.tencent.mm.plugin.fav.b.d;

import android.os.SystemClock;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.b.d.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class c$1 implements Runnable {
    final /* synthetic */ c iXM;

    c$1(c cVar) {
        this.iXM = cVar;
    }

    public final void run() {
        List<f> aLy = ((ae) g.n(ae.class)).getFavEditInfoStorage().aLy();
        if (aLy != null) {
            x.i("MicroMsg.Fav.FavEditService", "infos size %d", new Object[]{Integer.valueOf(aLy.size())});
            for (f fVar : aLy) {
                String v = c.v(fVar.field_localId, fVar.field_type);
                a aVar = (a) this.iXM.iXL.get(v);
                if (aVar == null) {
                    x.i("MicroMsg.Fav.FavEditService", "not match key %s", new Object[]{v});
                    aVar = new a((byte) 0);
                    aVar.iXc = fVar;
                    aVar.retryCount = 3;
                    aVar.time = SystemClock.elapsedRealtime();
                    this.iXM.iXL.put(v, aVar);
                    c.a(aVar, true);
                } else {
                    x.i("MicroMsg.Fav.FavEditService", "match key %s, check start", new Object[]{v});
                    c.a(aVar, false);
                }
            }
        }
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
