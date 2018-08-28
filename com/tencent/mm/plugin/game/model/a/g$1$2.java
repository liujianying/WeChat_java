package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.a.g.1;
import com.tencent.mm.plugin.game.model.a.g.2;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$1$2 implements Runnable {
    final /* synthetic */ 1 jOQ;

    g$1$2(1 1) {
        this.jOQ = 1;
    }

    public final void run() {
        int i;
        long j = 0;
        if (this.jOQ.jOO.field_isFirst) {
            f aSl = ((c) g.l(c.class)).aSl();
            if (bi.oW(this.jOQ.jOO.field_appId)) {
                x.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
            } else {
                boolean fV = aSl.fV("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[]{"GameSilentDownload", "isFirst", "appId", this.jOQ.jOO.field_appId}));
                x.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[]{Boolean.valueOf(fV)});
            }
            long j2 = this.jOQ.jOO.field_randomTime;
            if (j2 > 0) {
                x.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[]{Integer.valueOf(bi.eF((int) j2, 0))});
                j = ((long) i) + bi.VE();
            }
            ((c) g.l(c.class)).aSl().E(this.jOQ.jOO.field_appId, j);
            if (bi.VE() >= j) {
                i = 1;
            }
            i = 0;
        } else {
            if (bi.VE() >= this.jOQ.jOO.field_nextCheckTime) {
                i = 1;
            }
            i = 0;
        }
        if (i != 0) {
            g gVar = this.jOQ.jOP;
            String str = this.jOQ.jOO.field_appId;
            x.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[]{Integer.valueOf(1), str});
            a aVar = new a();
            aVar.dIF = 2819;
            aVar.dII = 0;
            aVar.dIJ = 0;
            aVar.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
            mz mzVar = new mz();
            mzVar.rdq = 1;
            mzVar.jQb = str;
            com.tencent.mm.plugin.downloader.c.a yK = com.tencent.mm.plugin.downloader.model.c.yK(str);
            if (yK != null) {
                mzVar.rcY = yK.field_downloadUrl;
                mzVar.rrd = yK.field_downloadedSize;
            }
            aVar.dIG = mzVar;
            aVar.dIH = new na();
            v.a(aVar.KT(), new 2(gVar, str));
        }
    }
}
