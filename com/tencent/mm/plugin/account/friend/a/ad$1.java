package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.modelsimple.i;

class ad$1 implements Runnable {
    final /* synthetic */ int dRC;
    final /* synthetic */ ad eKW;

    ad$1(ad adVar, int i) {
        this.eKW = adVar;
        this.dRC = i;
    }

    public final void run() {
        new i().a(this.eKW.dIX, new 1(this));
    }
}
