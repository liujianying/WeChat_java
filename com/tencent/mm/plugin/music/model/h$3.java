package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class h$3 extends c<js> {
    final /* synthetic */ h lyB;

    h$3(h hVar) {
        this.lyB = hVar;
        this.sFo = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        js jsVar = (js) bVar;
        avq avq;
        switch (jsVar.bTw.action) {
            case -3:
                jsVar.bTx.bGZ = h.bic().bhQ().PY();
                break;
            case -2:
                jsVar.bTx.bTy = h.bic().bhS();
                break;
            case -1:
                h.bic().PW();
                break;
            case 0:
                h.bic().e(jsVar.bTw.bTy);
                break;
            case 1:
                h.bic().bhQ().bhB();
                break;
            case 2:
                h.bic().bhQ().resume();
                break;
            case 3:
                e bic = h.bic();
                avq = jsVar.bTw.bTy;
                if (avq == null) {
                    x.i("MicroMsg.Music.MusicPlayerManager", "shake music item is null");
                    break;
                }
                bic.lyb.clear();
                bic.lyb.add(a.x(avq));
                bic.lya = 0;
                h.bid().w(avq);
                break;
            case 4:
                e bic2 = h.bic();
                List list = jsVar.bTw.bPa;
                int i = jsVar.bTw.bTz;
                if (list != null && list.size() != 0 && i < list.size()) {
                    bic2.lyb.clear();
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        avq avq2 = (avq) list.get(i2);
                        bic2.lyb.add(a.x(avq2));
                        h.bid().w(avq2);
                    }
                    bic2.lya = i;
                    x.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList:%d", new Object[]{Integer.valueOf(bic2.lya)});
                    com.tencent.mm.an.a bhR = bic2.bhR();
                    avq = bic2.bhS();
                    if (bhR != null && g.g(bhR)) {
                        x.i("MicroMsg.Music.MusicPlayerManager", "musicType %d", new Object[]{Integer.valueOf(bhR.field_musicType)});
                        if (bhR.field_isBlock != 1) {
                            bic2.mode = 2;
                            com.tencent.mm.plugin.music.model.a.b.h(bhR);
                            if (!com.tencent.mm.plugin.music.model.a.b.i(bhR)) {
                                bic2.d(bhR);
                                break;
                            }
                            x.i("MicroMsg.Music.MusicPlayerManager", "get shake music new url to play");
                            bic2.Is(bhR.playUrl);
                            break;
                        }
                        x.i("MicroMsg.Music.MusicPlayerManager", "not play music list, music is block %s", new Object[]{bhR.field_musicId});
                        bic2.f(avq);
                        f.a(bhR, true);
                        break;
                    }
                    x.e("MicroMsg.Music.MusicPlayerManager", "music is null, do not start music");
                    bic2.f(avq);
                    break;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "music wrapper list error");
                break;
                break;
            case 5:
                h.bic().f(jsVar.bTw.bPa, jsVar.bTw.bTA);
                break;
            case 6:
                e bic3 = h.bic();
                avq avq3 = jsVar.bTw.bTy;
                if (avq3 != null) {
                    boolean z;
                    String x = a.x(avq3);
                    if (bic3.lyb != null) {
                        int i3 = 0;
                        while (i3 < bic3.lyb.size()) {
                            if (x.equals(bic3.lyb.get(i3))) {
                                bic3.lya = i3;
                                z = true;
                                if (bic3.lyb.size() > 1 && avq3.rYB) {
                                    bic3.mode = 2;
                                }
                            } else {
                                i3++;
                            }
                        }
                        z = false;
                        bic3.mode = 2;
                        break;
                    }
                    z = false;
                    if (!z) {
                        bic3.e(avq3);
                        break;
                    }
                    bic3.e(null);
                    break;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                break;
            case 7:
                jsVar.bTx.bGZ = h.bic().bhQ().if(jsVar.bTw.position);
                break;
            case 8:
                jsVar.bTx.bTC = h.bic().bhQ().bhq();
                break;
            case 9:
                jsVar.bTx.bGZ = h.bic().bhQ().PZ();
                break;
            case 10:
                jsVar.bTx.bGZ = h.bic().bhQ().bho();
                break;
            case 11:
                h.bic().bhY();
                break;
        }
        return false;
    }
}
