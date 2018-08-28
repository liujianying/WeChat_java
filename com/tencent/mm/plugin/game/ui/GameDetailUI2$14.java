package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.sdk.platformtools.ah;

class GameDetailUI2$14 implements Runnable {
    final /* synthetic */ a jVF;
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$14(GameDetailUI2 gameDetailUI2, a aVar) {
        this.jXr = gameDetailUI2;
        this.jVF = aVar;
    }

    public final void run() {
        ah.A(new 1(this, new ae(this.jVF)));
    }
}
