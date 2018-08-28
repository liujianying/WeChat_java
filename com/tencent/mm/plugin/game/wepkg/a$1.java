package com.tencent.mm.plugin.game.wepkg;

import com.tencent.mm.plugin.game.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.game.wepkg.model.a;
import com.tencent.mm.plugin.game.wepkg.model.f;
import com.tencent.mm.plugin.game.wepkg.model.g;
import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.plugin.game.wepkg.utils.d;

class a$1 extends a {
    final /* synthetic */ boolean kdO;
    final /* synthetic */ a kdP;

    a$1(a aVar, boolean z) {
        this.kdP = aVar;
        this.kdO = z;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        boolean aVy = g.aVy();
        b.kgl = aVy;
        if (!aVy && (baseWepkgProcessTask instanceof WepkgCrossProcessTask)) {
            final String str = ((WepkgCrossProcessTask) baseWepkgProcessTask).kfj;
            d.Em().H(new Runnable() {
                public final void run() {
                    f.Eh(str);
                    if (!a$1.this.kdO) {
                        WepkgVersionManager.g(d.Eu(str), 0, -1, a.a(a$1.this.kdP));
                    }
                }
            });
        }
    }
}
