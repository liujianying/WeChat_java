package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.g.a.kk;

class c$b implements Runnable {
    final /* synthetic */ c keU;
    private final kk keX;

    public c$b(c cVar, kk kkVar) {
        this.keU = cVar;
        this.keX = kkVar;
    }

    public final void run() {
        c.a(this.keU, this.keX);
    }
}
