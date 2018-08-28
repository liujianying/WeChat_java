package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$6 implements c {
    final /* synthetic */ avq ebb;
    final /* synthetic */ MusicMainUI lBe;

    MusicMainUI$6(MusicMainUI musicMainUI, avq avq) {
        this.lBe = musicMainUI;
        this.ebb = avq;
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
                g.b(this.ebb, this.lBe);
                f.tA(4);
                return;
            default:
                return;
        }
    }
}
