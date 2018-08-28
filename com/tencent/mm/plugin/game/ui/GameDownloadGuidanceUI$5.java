package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.sdk.platformtools.ah;

class GameDownloadGuidanceUI$5 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ a jVF;
    final /* synthetic */ GameDownloadGuidanceUI jXC;

    GameDownloadGuidanceUI$5(GameDownloadGuidanceUI gameDownloadGuidanceUI, a aVar, long j) {
        this.jXC = gameDownloadGuidanceUI;
        this.jVF = aVar;
        this.cXh = j;
    }

    public final void run() {
        if (this.jVF == null) {
            GameDownloadGuidanceUI.a(this.jXC, new bh());
        } else {
            GameDownloadGuidanceUI.a(this.jXC, (bh) this.jVF);
        }
        ah.A(new 1(this, new ag(this.jVF)));
    }
}
