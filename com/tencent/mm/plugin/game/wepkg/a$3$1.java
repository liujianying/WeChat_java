package com.tencent.mm.plugin.game.wepkg;

import com.tencent.mm.plugin.game.wepkg.a.3;
import com.tencent.mm.plugin.game.wepkg.model.f;
import com.tencent.mm.plugin.game.wepkg.utils.a;
import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1 implements Runnable {
    final /* synthetic */ 3 kdR;

    a$3$1(3 3) {
        this.kdR = 3;
    }

    public final void run() {
        try {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
            a.d(this.kdR.kdP);
            a.e(this.kdR.kdP).loadUrl(a.b(this.kdR.kdP));
            int f = a.f(this.kdR.kdP);
            if (f > 1) {
                if (a.g(this.kdR.kdP) != null) {
                    a.b("whiteScreen", a.b(this.kdR.kdP), a.g(this.kdR.kdP).kfA, a.g(this.kdR.kdP).version, -1, 0, null);
                }
                h.mEJ.a(859, 13, 1, false);
                String Eu = d.Eu(a.b(this.kdR.kdP));
                b.kgk.Es(Eu);
                if (!bi.oW(Eu)) {
                    f.Ei(Eu);
                }
                a.h(this.kdR.kdP);
                return;
            }
            a.a(this.kdR.kdP, f + 1);
        } catch (Exception e) {
        }
    }
}
