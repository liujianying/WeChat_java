package com.tencent.mm.plugin.game.wepkg;

import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.game.wepkg.utils.d;

class a$2 implements Runnable {
    final /* synthetic */ boolean kdO;
    final /* synthetic */ a kdP;

    a$2(a aVar, boolean z) {
        this.kdP = aVar;
        this.kdO = z;
    }

    public final void run() {
        if (!this.kdO) {
            WepkgVersionManager.g(d.Eu(a.b(this.kdP)), 0, -1, a.a(this.kdP));
        }
    }
}
