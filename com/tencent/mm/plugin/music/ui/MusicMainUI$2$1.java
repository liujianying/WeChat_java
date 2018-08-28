package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.ui.MusicMainUI.2;

class MusicMainUI$2$1 implements Runnable {
    final /* synthetic */ jt lBf;
    final /* synthetic */ 2 lBg;

    MusicMainUI$2$1(2 2, jt jtVar) {
        this.lBg = 2;
        this.lBf = jtVar;
    }

    public final void run() {
        if (this.lBf.bTE.action == 0 && h.bic().mode != 2) {
            MusicMainUI.i(this.lBg.lBe).setAdapter(MusicMainUI.h(this.lBg.lBe));
            MusicMainUI.i(this.lBg.lBe).setCurrentItem(100000 + h.bic().lya);
        }
        MusicMainUI.j(this.lBg.lBe);
    }
}
