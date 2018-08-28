package com.tencent.mm.plugin.fav.b.d;

import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$2 extends a {
    final /* synthetic */ b iXK;

    b$2(b bVar) {
        this.iXK = bVar;
    }

    public final void ev(int i) {
        try {
            boolean isWifi = ao.isWifi(ad.getContext());
            if (i == 4 || i == 6) {
                x.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(b.c(this.iXK))});
                if (!b.c(this.iXK) && isWifi) {
                    b bVar = this.iXK;
                    List<g> aLB = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLB();
                    if (aLB == null || aLB.size() <= 0) {
                        x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                    } else {
                        x.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", new Object[]{Integer.valueOf(aLB.size())});
                        for (g gVar : aLB) {
                            if (gVar.field_itemStatus == 3) {
                                gVar.field_itemStatus = 1;
                                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                            }
                        }
                        bVar.run();
                    }
                }
                b.a(this.iXK, isWifi);
                return;
            }
            b.a(this.iXK, isWifi);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e, "", new Object[0]);
        }
    }
}
