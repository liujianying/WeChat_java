package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class MusicMainUI$b extends a {
    final /* synthetic */ MusicMainUI lBe;

    private MusicMainUI$b(MusicMainUI musicMainUI) {
        this.lBe = musicMainUI;
    }

    /* synthetic */ MusicMainUI$b(MusicMainUI musicMainUI, byte b) {
        this(musicMainUI);
    }

    public final void biM() {
        x.i("MicroMsg.Music.MusicMainUI", "shake %b", new Object[]{Boolean.valueOf(true)});
        long bI = bi.bI(MusicMainUI.d(this.lBe));
        if (bI < 1200) {
            x.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + bI);
            return;
        }
        x.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + bI);
        MusicMainUI.a(this.lBe, bi.VG());
        MusicMainUI.e(this.lBe);
        if (MusicMainUI.f(this.lBe) % 2 == 0) {
            e bic = h.bic();
            int g = MusicMainUI.g(this.lBe);
            com.tencent.mm.plugin.report.service.h.mEJ.a(285, 2, 1, false);
            jt jtVar;
            if (bic.mode != 1) {
                bic.mode = 1;
                jtVar = new jt();
                jtVar.bTE.action = 5;
                com.tencent.mm.sdk.b.a.sFg.m(jtVar);
                f.R(2, 1, g);
            } else if (bic.lyj) {
                x.i("MicroMsg.Music.MusicPlayerManager", "already running get list");
            } else {
                bic.mode = 2;
                if (bic.lyb.size() <= 1) {
                    bic.bhT();
                } else {
                    jtVar = new jt();
                    jtVar.bTE.action = 5;
                    com.tencent.mm.sdk.b.a.sFg.m(jtVar);
                }
                f.R(1, 2, g);
            }
        }
    }

    public final void onRelease() {
    }
}
