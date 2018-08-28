package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.m.2;
import com.tencent.mm.sdk.platformtools.x;

class m$2$1 implements Runnable {
    final /* synthetic */ 2 kab;

    m$2$1(2 2) {
        this.kab = 2;
    }

    public final void run() {
        m.c(this.kab.jZZ, this.kab.jZY);
        x.i("MicroMsg.GameListAdapter", "set size: %d", new Object[]{Integer.valueOf(this.kab.jZY.size())});
    }
}
