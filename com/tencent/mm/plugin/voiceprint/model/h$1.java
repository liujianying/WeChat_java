package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.i;

class h$1 implements Runnable {
    final /* synthetic */ int dRC;
    final /* synthetic */ h oFf;

    h$1(h hVar, int i) {
        this.oFf = hVar;
        this.dRC = i;
    }

    public final void run() {
        new i().a(this.oFf.dIX, new 1(this));
    }
}
