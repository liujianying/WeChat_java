package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.6;
import com.tencent.mm.sdk.platformtools.x;

class GameOverSeaCenterUI$6$1 implements Runnable {
    final /* synthetic */ ak kbr;
    final /* synthetic */ 6 kbs;

    GameOverSeaCenterUI$6$1(6 6, ak akVar) {
        this.kbs = 6;
        this.kbr = akVar;
    }

    public final void run() {
        try {
            GameOverSeaCenterUI.a(this.kbs.kbp, this.kbr, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", new Object[]{e.getMessage()});
            this.kbs.kbp.finish();
        }
        if (GameOverSeaCenterUI.a(this.kbs.kbp) != null) {
            GameOverSeaCenterUI.a(this.kbs.kbp).dismiss();
        }
        x.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.kbs.cXh)});
    }
}
