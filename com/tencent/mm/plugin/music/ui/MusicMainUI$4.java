package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$4 implements c {
    final /* synthetic */ String bAj;
    final /* synthetic */ avq ebb;
    final /* synthetic */ int fen;
    final /* synthetic */ MusicMainUI lBe;
    final /* synthetic */ String lBh;

    MusicMainUI$4(MusicMainUI musicMainUI, avq avq, String str, String str2, int i) {
        this.lBe = musicMainUI;
        this.ebb = avq;
        this.bAj = str;
        this.lBh = str2;
        this.fen = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                g.x(this.lBe);
                f.ty(MusicMainUI.g(this.lBe));
                f.tA(2);
                return;
            case 1:
                g.c(this.ebb, this.lBe);
                f.tz(MusicMainUI.g(this.lBe));
                f.tA(1);
                return;
            case 2:
                g.a(this.ebb, this.lBe);
                f.tA(3);
                return;
            case 3:
                g.F(this.bAj, this.lBh, this.fen);
                return;
            default:
                return;
        }
    }
}
