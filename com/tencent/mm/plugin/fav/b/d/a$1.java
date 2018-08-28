package com.tencent.mm.plugin.fav.b.d;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends a {
    final /* synthetic */ a iXG;

    a$1(a aVar) {
        this.iXG = aVar;
    }

    public final void ev(int i) {
        try {
            boolean isWifi = ao.isWifi(ad.getContext());
            x.i("MicroMsg.Fav.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.iXG.iXC)});
            if (i == 4 || i == 6) {
                a aVar;
                if (this.iXG.iXC && !isWifi) {
                    c cVar;
                    aVar = this.iXG;
                    x.i("MicroMsg.Fav.FavCdnService", "pauseAll");
                    Cursor aLv = ((ae) g.n(ae.class)).getFavCdnStorage().aLv();
                    if (aLv != null && aLv.moveToFirst()) {
                        while (aLv.moveToNext()) {
                            cVar = new c();
                            cVar.d(aLv);
                            x.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[]{cVar.field_dataId});
                            cVar.field_status = 4;
                            ((ae) g.n(ae.class)).getFavCdnStorage().a(cVar, new String[]{"dataId"});
                            com.tencent.mm.modelcdntran.g.ND().lw(cVar.field_dataId);
                            a.g(((ae) g.n(ae.class)).getFavCdnStorage().Br(cVar.field_dataId));
                            aVar.Bw(cVar.field_dataId);
                        }
                        aLv.close();
                    }
                    aLv = ((ae) g.n(ae.class)).getFavCdnStorage().aLw();
                    if (aLv != null && aLv.moveToFirst()) {
                        while (aLv.moveToNext()) {
                            cVar = new c();
                            cVar.d(aLv);
                            x.i("MicroMsg.Fav.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[]{cVar.field_dataId});
                            cVar.field_status = 4;
                            ((ae) g.n(ae.class)).getFavCdnStorage().a(cVar, new String[]{"dataId"});
                            com.tencent.mm.modelcdntran.g.ND().lx(cVar.field_dataId);
                            a.g(((ae) g.n(ae.class)).getFavCdnStorage().Br(cVar.field_dataId));
                            aVar.Bw(cVar.field_dataId);
                        }
                    }
                    if (aLv != null) {
                        aLv.close();
                    }
                }
                if (!this.iXG.iXC && isWifi) {
                    aVar = this.iXG;
                    x.i("MicroMsg.Fav.FavCdnService", "startAll");
                    ((ae) g.n(ae.class)).getFavCdnStorage().aLt();
                    aVar.run();
                }
                this.iXG.iXC = isWifi;
                return;
            }
            this.iXG.iXC = isWifi;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Fav.FavCdnService", e, "", new Object[0]);
        }
    }
}
