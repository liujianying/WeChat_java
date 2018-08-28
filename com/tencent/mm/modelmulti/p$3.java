package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.modelmulti.p.d;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class p$3 implements Runnable {
    final /* synthetic */ c eaA;
    final /* synthetic */ p eay;

    p$3(p pVar, c cVar) {
        this.eay = pVar;
        this.eaA = cVar;
    }

    public final void run() {
        boolean z = true;
        if (a.Dr() || !g.Eg().Dx()) {
            x.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
            return;
        }
        c cVar;
        if (this.eaA != null) {
            x.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", new Object[]{this.eaA, p.a(this.eay), Long.valueOf(bi.bH(p.d(this.eay)))});
            if (this.eaA != p.a(this.eay)) {
                for (c cVar2 : p.e(this.eay).keySet()) {
                    x.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", new Object[]{cVar2, Long.valueOf(bi.bH(((Long) p.e(this.eay).get(cVar2)).longValue()))});
                }
                p.F("oldproc timeout, should in timeoutMap:" + this.eaA, bi.a((Long) p.e(this.eay).remove(this.eaA), -1) != -1);
                return;
            }
            p.a(this.eaA, p.d(this.eay));
            p.b(this.eay, null);
            p.a(this.eay, 0);
            p.f(this.eay);
        }
        if (p.a(this.eay) != null) {
            if (bi.bH(p.d(this.eay)) > 90000) {
                x.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", new Object[]{p.a(this.eay), Long.valueOf(bi.bH(p.d(this.eay)))});
                p.c(p.a(this.eay));
                p.e(this.eay).put(p.a(this.eay), Long.valueOf(p.d(this.eay)));
                p.b(this.eay, null);
                p.a(this.eay, 0);
                p.f(this.eay);
            } else {
                x.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", new Object[]{p.a(this.eay), Long.valueOf(bi.bH(p.d(this.eay)))});
                return;
            }
        }
        b bVar = (b) g.l(b.class);
        if (bVar.cbe().IO()) {
            x.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
            bVar.cbe().IM();
        } else if (bVar.cbe().IP()) {
            x.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
        } else {
            d dVar = new d(this.eay);
            if (dVar.c(null)) {
                p.a(this.eay, "LightPush");
                p.b(this.eay, dVar);
                p.a(this.eay, bi.VF());
                return;
            }
            while (!p.b(this.eay).isEmpty()) {
                cVar2 = (c) p.b(this.eay).poll();
                x.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", new Object[]{Integer.valueOf(p.b(this.eay).size()), cVar2});
                if (cVar2 != null && cVar2.c(null)) {
                    p.a(this.eay, "NotifyData");
                    p.b(this.eay, cVar2);
                    p.a(this.eay, bi.VF());
                    return;
                }
            }
            if (!p.c(this.eay).isEmpty()) {
                cVar2 = (c) p.c(this.eay).poll();
                x.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", new Object[]{Integer.valueOf(p.c(this.eay).size()), cVar2});
                if (cVar2 != null && cVar2.c(p.c(this.eay))) {
                    p.a(this.eay, "NetSync");
                    p.b(this.eay, cVar2);
                    p.a(this.eay, bi.VF());
                    return;
                }
            }
            x.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", new Object[]{p.a(this.eay), Integer.valueOf(p.c(this.eay).size()), Integer.valueOf(p.b(this.eay).size())});
            String str = "";
            if (!(p.a(this.eay) == null && p.c(this.eay).isEmpty() && p.b(this.eay).isEmpty())) {
                z = false;
            }
            p.F(str, z);
        }
    }
}
