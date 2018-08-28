package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.modelsimple.i;

class e$1 implements Runnable {
    final /* synthetic */ int dRC;
    final /* synthetic */ e oEU;

    e$1(e eVar, int i) {
        this.oEU = eVar;
        this.dRC = i;
    }

    public final void run() {
        new i().a(this.oEU.dIX, new 1(this));
    }
}
