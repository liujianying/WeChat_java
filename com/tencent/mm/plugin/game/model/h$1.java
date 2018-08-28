package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;

class h$1 implements Runnable {
    final /* synthetic */ h jLO;

    h$1(h hVar) {
        this.jLO = hVar;
    }

    public final void run() {
        h.a(this.jLO, ((c) g.l(c.class)).aSk().Dw("pb_game_global_config"));
    }
}
