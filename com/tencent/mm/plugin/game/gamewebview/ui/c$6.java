package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$6 implements Runnable {
    final /* synthetic */ c jIM;

    c$6(c cVar) {
        this.jIM = cVar;
    }

    public final void run() {
        x.d("MicroMsg.GameWebPageContainer", "anim end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.jIM))});
        this.jIM.postDelayed(new 1(this), 500);
    }
}
