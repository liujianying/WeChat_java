package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2;
import com.tencent.mm.sdk.platformtools.x;

class GameOverSeaCenterUI$2$2 implements Runnable {
    final /* synthetic */ 2 kbq;
    final /* synthetic */ ak kbr;

    GameOverSeaCenterUI$2$2(2 2, ak akVar) {
        this.kbq = 2;
        this.kbr = akVar;
    }

    public final void run() {
        try {
            GameOverSeaCenterUI.a(this.kbq.kbp, this.kbr, 1);
        } catch (Exception e) {
            x.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[]{e.getMessage()});
            this.kbq.kbp.finish();
        }
    }
}
