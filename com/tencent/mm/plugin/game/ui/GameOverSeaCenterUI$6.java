package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.sdk.platformtools.ah;

class GameOverSeaCenterUI$6 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ a jVF;
    final /* synthetic */ GameOverSeaCenterUI kbp;

    GameOverSeaCenterUI$6(GameOverSeaCenterUI gameOverSeaCenterUI, a aVar, long j) {
        this.kbp = gameOverSeaCenterUI;
        this.jVF = aVar;
        this.cXh = j;
    }

    public final void run() {
        if (this.jVF == null) {
            GameOverSeaCenterUI.a(this.kbp, new bj());
        } else {
            GameOverSeaCenterUI.a(this.kbp, (bj) this.jVF);
        }
        ah.A(new 1(this, new ak(this.jVF)));
    }
}
