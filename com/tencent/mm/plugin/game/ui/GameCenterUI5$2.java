package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.sdk.platformtools.ah;

class GameCenterUI5$2 implements Runnable {
    final /* synthetic */ long cXh;
    final /* synthetic */ GameCenterUI5 jVE;
    final /* synthetic */ a jVF;

    GameCenterUI5$2(GameCenterUI5 gameCenterUI5, a aVar, long j) {
        this.jVE = gameCenterUI5;
        this.jVF = aVar;
        this.cXh = j;
    }

    public final void run() {
        bd bdVar;
        if (this.jVF == null) {
            bdVar = new bd();
        } else {
            bdVar = (bd) this.jVF;
            ((c) g.l(c.class)).aSk().a("pb_index_4", bdVar);
        }
        ah.A(new 1(this, new com.tencent.mm.plugin.game.model.ah(bdVar)));
    }
}
