package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e implements com.tencent.mm.ab.e, ac {
    private static Map<Long, a> bFf = new HashMap();
    private static Map<Long, Integer> iXO = new HashMap();
    private static Set<Long> iXQ = new HashSet();
    private Queue<g> bFd = new LinkedList();
    private boolean bFh = false;
    private boolean bFi = false;
    public int bFj = 0;
    private long bFk = 0;
    public al bFo = new al(com.tencent.mm.kernel.g.Em().lnJ.getLooper(), new 3(this), false);

    static /* synthetic */ boolean d(e eVar) {
        g gVar;
        x.i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        eVar.bFk = System.currentTimeMillis();
        if (!eVar.bFh && eVar.bFd.size() == 0) {
            List<g> aLD = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLD();
            if (!(aLD == null || aLD.size() == 0)) {
                for (g gVar2 : aLD) {
                    if (iXQ.contains(Long.valueOf(gVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", new Object[]{Integer.valueOf(gVar2.field_id), Long.valueOf(gVar2.field_localId), Integer.valueOf(gVar2.field_sourceType), gVar2.field_sourceId});
                    } else if (bFf.containsKey(Long.valueOf(gVar2.field_localId))) {
                        x.i("MicroMsg.Fav.FavSendService", "File is Already running:" + gVar2.field_localId);
                    } else {
                        if (!iXO.containsKey(Long.valueOf(gVar2.field_localId))) {
                            iXO.put(Long.valueOf(gVar2.field_localId), Integer.valueOf(3));
                        }
                        eVar.bFd.add(gVar2);
                        bFf.put(Long.valueOf(gVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + bFf.size() + ",send:" + eVar.bFd.size() + "]");
                eVar.bFd.size();
            }
        }
        if (eVar.bFh || eVar.bFd.size() > 0) {
            x.i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", new Object[]{Integer.valueOf(eVar.bFd.size())});
            if (!eVar.bFh && eVar.bFd.size() > 0) {
                gVar2 = (g) eVar.bFd.poll();
                if (gVar2 != null && gVar2.field_localId > 0) {
                    eVar.bFh = true;
                    com.tencent.mm.kernel.g.DF().a(new af(gVar2), 0);
                    return true;
                }
            }
        }
        eVar.e();
        x.i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        return false;
    }

    public e() {
        com.tencent.mm.kernel.g.DF().a(401, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.kernel.g.Em().H(new 1(this, lVar, i, i2));
    }

    public final boolean TM() {
        return this.bFh;
    }

    public final void run() {
        com.tencent.mm.kernel.g.Em().H(new 2(this));
    }

    /* renamed from: wx */
    public final void e() {
        x.i("MicroMsg.Fav.FavSendService", "on finish");
        this.bFd.clear();
        bFf.clear();
        this.bFi = false;
        this.bFh = false;
        iXO.clear();
    }

    public static void startSync() {
        com.tencent.mm.kernel.g.DF().a(new aj(), 0);
    }
}
