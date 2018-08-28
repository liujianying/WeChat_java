package com.tencent.mm.plugin.hp.tinker;

import com.tencent.mm.plugin.hp.tinker.a.a;

class a$1 implements Runnable {
    final /* synthetic */ a kmW;
    final /* synthetic */ a kmX;

    a$1(a aVar, a aVar2) {
        this.kmX = aVar;
        this.kmW = aVar2;
    }

    public final void run() {
        if (this.kmW != null) {
            com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
            this.kmW.aWq();
        }
    }
}
