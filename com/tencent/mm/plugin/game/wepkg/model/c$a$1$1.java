package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.model.c.a.1;

class c$a$1$1 implements Runnable {
    final /* synthetic */ 1 keW;
    final /* synthetic */ String val$url;

    c$a$1$1(1 1, String str) {
        this.keW = 1;
        this.val$url = str;
    }

    public final void run() {
        f.Eh(this.val$url);
        if (this.keW.dmx != null) {
            this.keW.dmx.at(this.keW.bAE);
        }
    }
}
