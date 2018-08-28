package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ e iXR;

    e$1(e eVar, l lVar, int i, int i2) {
        this.iXR = eVar;
        this.bFp = lVar;
        this.bFq = i;
        this.bFr = i2;
    }

    public final void run() {
        if (this.bFp.getType() == 401 && (this.bFp instanceof af)) {
            e.a(this.iXR);
            g gVar = ((af) this.bFp).iWJ;
            long j = gVar.field_localId;
            e.QV().remove(Long.valueOf(j));
            if ((this.bFq == 0 && this.bFr == 0) || this.bFr == -400) {
                e.amM().add(Long.valueOf(j));
            }
            if (!(this.bFq == 0 || this.bFr == -400)) {
                e.b(this.iXR);
            }
            Integer valueOf = Integer.valueOf(bi.a((Integer) e.aMa().get(Long.valueOf(j)), 0));
            if (!(this.bFq == 1 || this.bFq == 0)) {
                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                e.aMa().put(Long.valueOf(gVar.field_localId), valueOf);
            }
            if (valueOf.intValue() <= 0) {
                int cA = h.cA(this.bFq, this.bFr);
                com.tencent.mm.plugin.report.service.h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(gVar.field_type), Integer.valueOf(cA), Long.valueOf(b.b(gVar)), Long.valueOf(h.dr(gVar.field_localId))});
                e.aMa().remove(Long.valueOf(j));
                x.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                if (gVar.field_itemStatus == 12) {
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(14, gVar.field_localId);
                }
                if (gVar.field_itemStatus == 9) {
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(11, gVar.field_localId);
                }
            }
            if (e.c(this.iXR) <= 0) {
                x.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                e.e(this.iXR);
            } else if (!e.d(this.iXR)) {
                e.startSync();
            }
        }
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
