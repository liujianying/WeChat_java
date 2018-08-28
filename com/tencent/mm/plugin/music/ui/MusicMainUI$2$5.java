package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.ui.MusicMainUI.2;

class MusicMainUI$2$5 implements Runnable {
    final /* synthetic */ 2 lBg;

    MusicMainUI$2$5(2 2) {
        this.lBg = 2;
    }

    public final void run() {
        MusicMainUI.i(this.lBg.lBe).setCurrentItem(MusicMainUI.i(this.lBg.lBe).getCurrentItem() - 1);
    }
}
