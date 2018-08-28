package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.ui.base.h.c;

class MusicMainUI$5 implements c {
    final /* synthetic */ String bAj;
    final /* synthetic */ int fen;
    final /* synthetic */ MusicMainUI lBe;
    final /* synthetic */ String lBh;

    MusicMainUI$5(MusicMainUI musicMainUI, String str, String str2, int i) {
        this.lBe = musicMainUI;
        this.bAj = str;
        this.lBh = str2;
        this.fen = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                g.F(this.bAj, this.lBh, this.fen);
                return;
            default:
                return;
        }
    }
}
