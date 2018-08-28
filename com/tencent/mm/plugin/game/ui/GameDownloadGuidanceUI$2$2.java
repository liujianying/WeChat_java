package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2;
import com.tencent.mm.sdk.platformtools.x;

class GameDownloadGuidanceUI$2$2 implements Runnable {
    final /* synthetic */ 2 jXD;
    final /* synthetic */ ag jXE;

    GameDownloadGuidanceUI$2$2(2 2, ag agVar) {
        this.jXD = 2;
        this.jXE = agVar;
    }

    public final void run() {
        try {
            this.jXD.jXC.a(this.jXE, 1);
        } catch (Exception e) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[]{e.getMessage()});
            this.jXD.jXC.finish();
        }
    }
}
