package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.gt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$6 extends c<gt> {
    final /* synthetic */ c jFM;

    c$6(c cVar) {
        this.jFM = cVar;
        this.sFo = gt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gt gtVar = (gt) bVar;
        x.i("MicroMsg.GameEventListener", "opType = %d, opStatus = %d, appId = %s", new Object[]{Integer.valueOf(gtVar.bPU.opType), Integer.valueOf(gtVar.bPU.bPV), gtVar.bPU.appId});
        if (gtVar.bPU.opType != 0) {
            a cs;
            switch (gtVar.bPU.opType) {
                case 2:
                    m.aTQ();
                    m.a(gtVar.bPU.appId, gtVar.bPU.bPV, false, gtVar.bPU.bJv);
                    break;
                case 4:
                    an.a(gtVar.bPU.appId, gtVar.bPU.scene, 4, gtVar.bPU.bGm, gtVar.bPU.channelId);
                    break;
                case 6:
                    m.aTQ();
                    m.cZ(gtVar.bPU.appId, gtVar.bPU.bJv);
                    break;
                case 7:
                    an.a(gtVar.bPU.appId, gtVar.bPU.scene, 9, gtVar.bPU.bGm, "");
                    break;
                case 8:
                    an.a(gtVar.bPU.appId, gtVar.bPU.scene, 10, gtVar.bPU.bGm, "");
                    break;
                case 9:
                    cs = com.tencent.mm.plugin.downloader.model.c.cs(gtVar.bPU.bGm);
                    if (cs != null) {
                        an.a(cs.field_appId, cs.field_scene, 12, cs.field_startSize, cs.field_downloadedSize - cs.field_startSize, cs.field_totalSize, cs.field_downloadUrl, cs.field_errCode, cs.field_downloaderType, cs.field_channelId, (System.currentTimeMillis() - cs.field_startTime) / 1000, cs.field_startState, cs.field_downloadId, cs.field_extInfo);
                        break;
                    }
                    break;
                case 10:
                    cs = com.tencent.mm.plugin.downloader.model.c.cs(gtVar.bPU.bGm);
                    if (cs != null) {
                        an.a(cs.field_appId, cs.field_scene, 11, cs.field_startSize, cs.field_downloadedSize - cs.field_startSize, cs.field_totalSize, cs.field_downloadUrl, cs.field_errCode, cs.field_downloaderType, cs.field_channelId, (System.currentTimeMillis() - cs.field_startTime) / 1000, cs.field_startState, cs.field_downloadId, cs.field_extInfo);
                        break;
                    }
                    break;
                default:
                    ((com.tencent.mm.plugin.game.a.b) g.l(com.tencent.mm.plugin.game.a.b.class)).aSh();
                    y.b(gtVar.bPU.appId, gtVar.bPU.opType, gtVar.bPU.bPV, gtVar.bPU.openId, gtVar.bPU.bJv);
                    break;
            }
        }
        return false;
    }
}
