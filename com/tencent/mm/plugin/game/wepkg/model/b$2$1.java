package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.a.b;
import com.tencent.mm.plugin.game.wepkg.model.b.2;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$2$1 implements Runnable {
    final /* synthetic */ String keO;
    final /* synthetic */ 2 keP;

    b$2$1(2 2, String str) {
        this.keP = 2;
        this.keO = str;
    }

    public final void run() {
        if (!bi.oW(this.keO)) {
            return;
        }
        if (f.Ek(d.Et(this.keP.keN))) {
            com.tencent.mm.plugin.game.wepkg.a.d.aVo().DU(this.keP.keN);
            b.aVn().DU(this.keP.keN);
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg success. pkgid:%s", new Object[]{this.keP.keN});
            return;
        }
        x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg fail. pkgid:%s", new Object[]{this.keP.keN});
    }
}
