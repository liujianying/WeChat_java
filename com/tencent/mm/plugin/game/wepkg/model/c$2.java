package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c keU;

    c$2(c cVar) {
        this.keU = cVar;
    }

    public final void run() {
        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", new Object[]{Integer.valueOf(1000), c.ath()});
        c.Ef("");
    }
}
