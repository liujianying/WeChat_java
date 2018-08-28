package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.an.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.h;

class MusicMainUI$a implements Runnable {
    final /* synthetic */ MusicMainUI lBe;
    int position;

    public MusicMainUI$a(MusicMainUI musicMainUI, int i) {
        this.lBe = musicMainUI;
        this.position = i;
    }

    public final void run() {
        e bic = h.bic();
        int i = this.position;
        if (bic.lyb.size() != 0) {
            i = (i - 100000) % bic.lyb.size();
            if (i < 0) {
                i += bic.lyb.size();
            }
            if (i != bic.lya) {
                bic.lya = i;
                bic.e(null);
            }
        }
        a bhR = h.bic().bhR();
        if (bhR != null) {
            if (bhR.PT()) {
                this.lBe.q(bhR);
            }
            if (h.bic().bhW()) {
                MusicMainUI.i(this.lBe).setCanSlide(true);
            }
            MusicMainUI.a(this.lBe, bhR);
        }
    }
}
