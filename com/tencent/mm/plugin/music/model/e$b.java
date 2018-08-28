package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class e$b implements Runnable {
    final /* synthetic */ e lyl;
    List<String> lym;

    private e$b(e eVar) {
        this.lyl = eVar;
    }

    /* synthetic */ e$b(e eVar, byte b) {
        this(eVar);
    }

    public final void run() {
        String x = a.x(this.lyl.bhS());
        int i = this.lyl.lya;
        int i2 = 0;
        for (int i3 = 0; i3 < this.lym.size(); i3++) {
            if (((String) this.lym.get(i3)).equals(x)) {
                i = i3;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            int i4;
            for (i4 = i + 1; i4 < this.lym.size(); i4++) {
                this.lyl.lyb.add(this.lym.get(i4));
            }
            for (i4 = 0; i4 < i; i4++) {
                this.lyl.lyb.add(this.lym.get(i4));
            }
            x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[]{Integer.valueOf(this.lyl.lyb.size()), Integer.valueOf(this.lyl.lya)});
            jt jtVar = new jt();
            jtVar.bTE.action = 5;
            com.tencent.mm.sdk.b.a.sFg.m(jtVar);
        }
    }
}
