package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.i;

class g$1 implements Runnable {
    final /* synthetic */ int dRC;
    final /* synthetic */ g oFd;

    g$1(g gVar, int i) {
        this.oFd = gVar;
        this.dRC = i;
    }

    public final void run() {
        new i().a(this.oFd.dIX, new 1(this));
    }
}
