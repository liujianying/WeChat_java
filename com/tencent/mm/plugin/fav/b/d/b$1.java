package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ int bFq;
    final /* synthetic */ b iXK;

    b$1(b bVar, l lVar, int i) {
        this.iXK = bVar;
        this.bFp = lVar;
        this.bFq = i;
    }

    public final void run() {
        if (this.bFp.getType() == 404 && (this.bFp instanceof ai)) {
            b.a(this.iXK);
            long j = ((ai) this.bFp).iWQ.field_localId;
            g gVar = ((ai) this.bFp).iWQ;
            b.QV().remove(Long.valueOf(j));
            if (this.bFq != 0) {
                x.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                h.mEJ.h(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(gVar.field_type), Integer.valueOf(-2), Long.valueOf(b.b(gVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.dr(gVar.field_localId))});
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().t(3, j);
            }
            b.b(this.iXK);
        }
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
