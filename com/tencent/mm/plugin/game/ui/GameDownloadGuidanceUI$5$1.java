package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5;
import com.tencent.mm.sdk.platformtools.x;

class GameDownloadGuidanceUI$5$1 implements Runnable {
    final /* synthetic */ ag jXE;
    final /* synthetic */ 5 jXF;

    GameDownloadGuidanceUI$5$1(5 5, ag agVar) {
        this.jXF = 5;
        this.jXE = agVar;
    }

    public final void run() {
        try {
            this.jXF.jXC.a(this.jXE, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", new Object[]{e.getMessage()});
            this.jXF.jXC.finish();
        }
        if (GameDownloadGuidanceUI.a(this.jXF.jXC) != null) {
            GameDownloadGuidanceUI.a(this.jXF.jXC).dismiss();
        }
        x.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jXF.cXh)});
    }
}
