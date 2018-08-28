package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.an.a;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends c<jt> {
    final /* synthetic */ b lzm;

    public b$1(b bVar) {
        this.lzm = bVar;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        if (this.lzm.lzf != null) {
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", new Object[]{Integer.valueOf(jtVar.bTE.action)});
            a bhR;
            switch (jtVar.bTE.action) {
                case 0:
                case 1:
                case 11:
                    if (this.lzm.lzf != null) {
                        bhR = h.bic().bhR();
                        if (bhR != null) {
                            this.lzm.lzf.k(bhR);
                            break;
                        }
                        x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                        break;
                    }
                    break;
                case 2:
                    if (!(this.lzm.lzf == null || jtVar.bTE.bTH)) {
                        this.lzm.lzf.stop();
                        break;
                    }
                case 3:
                    if (this.lzm.lzf != null) {
                        bhR = h.bic().bhR();
                        if (bhR != null) {
                            this.lzm.lzf.l(bhR);
                            break;
                        }
                        x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                        break;
                    }
                    break;
                case 4:
                    if (this.lzm.lzf != null) {
                        this.lzm.lzf.stop();
                        break;
                    }
                    break;
                case 7:
                    if (h.bic().mode == 1 && this.lzm.lzf != null) {
                        MMMusicPlayerService mMMusicPlayerService = this.lzm.lzf;
                        x.i("MicroMsg.Music.MMMusicPlayerService", "end");
                        a aVar = mMMusicPlayerService.lzn;
                        if (!aVar.huc) {
                            x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                        } else if (aVar.lzf == null) {
                            x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                        } else {
                            x.i("MicroMsg.Music.MMMusicNotification", "end");
                            ah.M(aVar.lzh);
                            ah.i(aVar.lzh, 2000);
                        }
                        ah.M(mMMusicPlayerService.lzo);
                        ah.i(mMMusicPlayerService.lzo, 60000);
                        break;
                    }
            }
        }
        this.lzm.biq();
        return false;
    }
}
