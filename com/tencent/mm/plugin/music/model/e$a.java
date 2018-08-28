package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.js;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class e$a implements Runnable {
    final /* synthetic */ e lyl;

    private e$a(e eVar) {
        this.lyl = eVar;
    }

    /* synthetic */ e$a(e eVar, byte b) {
        this(eVar);
    }

    public final void run() {
        List list;
        long currentTimeMillis = System.currentTimeMillis();
        this.lyl.lyj = true;
        avq bhS = this.lyl.bhS();
        List arrayList = new ArrayList();
        x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper.MusicType:%d", new Object[]{Integer.valueOf(bhS.rYj)});
        js jsVar;
        switch (bhS.rYj) {
            case 1:
                jsVar = new js();
                jsVar.bTw.action = -5;
                a.sFg.m(jsVar);
                list = jsVar.bTx.bPa;
                break;
            case 4:
                jsVar = new js();
                jsVar.bTw.action = -4;
                a.sFg.m(jsVar);
                list = jsVar.bTx.bPa;
                break;
            case 6:
                fz fzVar = new fz();
                fzVar.bOL.type = 18;
                a.sFg.m(fzVar);
                list = fzVar.bOM.bPa;
                break;
            case 8:
                jsVar = new js();
                jsVar.bTw.action = -6;
                jsVar.bTw.bTy = bhS;
                a.sFg.m(jsVar);
                list = jsVar.bTx.bPa;
                break;
            default:
                list = null;
                break;
        }
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                avq avq = (avq) list.get(i);
                if (avq == null) {
                    x.e("MicroMsg.Music.MusicPlayerManager", "wrapper is null, continue");
                } else {
                    h.bid().w(avq);
                    arrayList.add(com.tencent.mm.plugin.music.d.a.x(avq));
                }
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask run time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.lyl.lyj = false;
        Runnable e_b = new e$b(this.lyl, (byte) 0);
        e_b.lym = arrayList;
        ah.A(e_b);
    }
}
