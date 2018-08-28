package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;

class GameOverSeaCenterUI$2 implements Runnable {
    final /* synthetic */ GameOverSeaCenterUI kbp;

    GameOverSeaCenterUI$2(GameOverSeaCenterUI gameOverSeaCenterUI) {
        this.kbp = gameOverSeaCenterUI;
    }

    public final void run() {
        byte[] Dw = ((c) g.l(c.class)).aSk().Dw("pb_over_sea");
        if (Dw == null) {
            ah.A(new Runnable() {
                public final void run() {
                    if (!GameOverSeaCenterUI$2.this.kbp.isFinishing()) {
                        GameOverSeaCenterUI.a(GameOverSeaCenterUI$2.this.kbp, com.tencent.mm.plugin.game.e.c.dD(GameOverSeaCenterUI$2.this.kbp));
                        GameOverSeaCenterUI.a(GameOverSeaCenterUI$2.this.kbp).show();
                    }
                }
            });
        } else {
            ah.A(new 2(this, new ak(Dw)));
        }
        ((b) g.l(b.class)).aSf().init(this.kbp);
        com.tencent.mm.plugin.game.e.c.R(f.aTz());
        ah.A(new 3(this));
        g.DF().a(new ax(w.chP(), f.aTz(), this.kbp.jVf, this.kbp.jVg, this.kbp.jVh, this.kbp.jVe), 0);
        f.aTE();
        a$a.kdf.aVf();
    }
}
