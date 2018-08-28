package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ai;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b implements e, r {
    private static Map<Long, a> bFf = new HashMap();
    private Queue<g> bFd = new LinkedList();
    private boolean bFh = false;
    private boolean bFi = false;
    private long bFk = 0;
    public al bFo = new al(com.tencent.mm.kernel.g.Em().lnJ.getLooper(), new 4(this), false);
    public n dOT = new 2(this);
    private boolean iXC = ao.isWifi(ad.getContext());

    static /* synthetic */ void b(b bVar) {
        g gVar;
        bVar.bFk = System.currentTimeMillis();
        if (!bVar.bFh && bVar.bFd.size() == 0) {
            List<g> aLC = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLC();
            if (!(aLC == null || aLC.size() == 0)) {
                for (g gVar2 : aLC) {
                    if (bFf.containsKey(Long.valueOf(gVar2.field_localId))) {
                        x.d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + gVar2.field_localId);
                    } else {
                        bVar.bFd.add(gVar2);
                        bFf.put(Long.valueOf(gVar2.field_localId), null);
                    }
                }
                x.i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + bFf.size() + ",send:" + bVar.bFd.size() + "]");
                bVar.bFd.size();
            }
        }
        if (!bVar.bFh && bVar.bFd.size() <= 0) {
            bVar.wx();
            x.i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        } else if (!bVar.bFh && bVar.bFd.size() > 0) {
            gVar2 = (g) bVar.bFd.poll();
            if (gVar2 != null && gVar2.field_localId > 0) {
                bVar.bFh = true;
                com.tencent.mm.kernel.g.DF().a(new ai(gVar2), 0);
            }
        }
    }

    public b() {
        com.tencent.mm.kernel.g.Eh().a(this.dOT);
        com.tencent.mm.kernel.g.DF().a(404, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        com.tencent.mm.kernel.g.Em().H(new 1(this, lVar, i));
    }

    public final void run() {
        com.tencent.mm.kernel.g.Em().H(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - b.this.bFk;
                if (b.this.bFi) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.this.bFi + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + b.this.bFi);
                    } else {
                        return;
                    }
                }
                b.this.bFh = false;
                b.this.bFi = true;
                b.this.bFo.J(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void wx() {
        this.bFd.clear();
        bFf.clear();
        this.bFi = false;
        this.bFh = false;
    }
}
