package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.b.c;
import com.tencent.mm.pluginsdk.g.a.b.e;
import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class d extends a<c> {
    public d(c cVar) {
        super(cVar);
    }

    public final String aca() {
        return "CheckResUpdate";
    }

    public final boolean bM(long j) {
        if (((c) ach()).fileSize <= 0 || ((c) ach()).fileSize == com.tencent.mm.pluginsdk.g.a.d.a.Io(getFilePath()) + j) {
            return super.bM(j);
        }
        return false;
    }

    public final boolean acg() {
        if (super.acg()) {
            j.n(((c) ach()).qBG, 12);
            return true;
        }
        j.n(((c) ach()).qBG, 27);
        return false;
    }

    protected final m a(j jVar) {
        c cVar = (c) ach();
        String Ti = i.Ti(cVar.qBy);
        String str = cVar.bKg;
        if (cVar.pON && bi.oV(g.cu(i.Ti(cVar.qBy))).equals(str)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            return new m(cVar, com.tencent.mm.pluginsdk.g.a.d.a.Io(Ti));
        } else if (!bi.bC(((c) ach()).qCe) && com.tencent.mm.pluginsdk.g.a.d.a.v(i.Ti(((c) ach()).qBy), ((c) ach()).qCe) && bi.oV(g.cu(i.Ti(((c) ach()).qBy))).equals(((c) ach()).bKg)) {
            return new m((l) ach(), com.tencent.mm.pluginsdk.g.a.d.a.Io(i.Ti(((c) ach()).qBy)));
        } else {
            m a = super.a(jVar);
            x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + a, new Object[]{cVar.qBy});
            if (a == null) {
                return new m("CheckResUpdate", cco(), getURL(), getFilePath(), 0, "", new e());
            }
            if (a.status == 2) {
                if (bi.oW(((c) ach()).bKg) || !((c) ach()).bKg.equals(g.cu(getFilePath()))) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[]{cVar.qBy});
                    return new m("CheckResUpdate", cco(), getURL(), getFilePath(), a.cfA, a.aBC, new c());
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[]{cVar.qBy});
            }
            return a;
        }
    }
}
