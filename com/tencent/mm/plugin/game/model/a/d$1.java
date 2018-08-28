package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.g.a.gs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class d$1 extends c<gs> {
    d$1() {
        this.sFo = gs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gs gsVar = (gs) bVar;
        switch (gsVar.bPT.bIH) {
            case 2:
                if (bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(a.sXT, Long.valueOf(0)))).longValue()) > 300) {
                    g.Ei().DT().a(a.sXT, Long.valueOf(bi.VE()));
                    g.a.aUH().fv(false);
                    break;
                }
                break;
            case 3:
                String str = gsVar.bPT.bPS;
                if (!bi.oW(str)) {
                    c cVar = new c();
                    cVar.field_appId = str;
                    ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().a(cVar, new String[0]);
                    x.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[]{str});
                    break;
                }
                boolean fV = ((com.tencent.mm.plugin.game.a.c) g.l(com.tencent.mm.plugin.game.a.c.class)).aSl().fV("GameSilentDownload", String.format("delete from %s", new Object[]{"GameSilentDownload"}));
                x.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[]{Boolean.valueOf(fV)});
                break;
            case 4:
                String str2 = gsVar.bPT.bPS;
                if (!bi.oW(str2)) {
                    com.tencent.mm.plugin.downloader.c.a yK = com.tencent.mm.plugin.downloader.model.c.yK(str2);
                    if (yK != null) {
                        d.aCU().cl(yK.field_downloadId);
                        com.tencent.mm.plugin.downloader.model.c.ct(yK.field_downloadId);
                        x.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[]{str2});
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
