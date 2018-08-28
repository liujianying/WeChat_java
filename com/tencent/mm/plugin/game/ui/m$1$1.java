package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.m.1;
import com.tencent.mm.sdk.platformtools.x;

class m$1$1 implements Runnable {
    final /* synthetic */ 1 kaa;

    m$1$1(1 1) {
        this.kaa = 1;
    }

    public final void run() {
        m.b(this.kaa.jZZ, this.kaa.jZY);
        x.i("MicroMsg.GameListAdapter", "add size: %d", new Object[]{Integer.valueOf(this.kaa.jZY.size())});
    }
}
