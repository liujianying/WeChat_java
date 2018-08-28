package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2;

class GameDownloadGuidanceUI$2$1 implements Runnable {
    final /* synthetic */ 2 jXD;

    GameDownloadGuidanceUI$2$1(2 2) {
        this.jXD = 2;
    }

    public final void run() {
        if (!this.jXD.jXC.isFinishing()) {
            GameDownloadGuidanceUI.a(this.jXD.jXC, c.dD(this.jXD.jXC));
            GameDownloadGuidanceUI.a(this.jXD.jXC).show();
        }
    }
}
