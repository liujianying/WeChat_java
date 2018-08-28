package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask;
import com.tencent.mm.plugin.game.wepkg.utils.WepkgRunCgi.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.x;

class WepkgVersionManager$WepkgNetSceneProcessTask$1 implements a {
    final /* synthetic */ WepkgNetSceneProcessTask kgf;

    WepkgVersionManager$WepkgNetSceneProcessTask$1(WepkgNetSceneProcessTask wepkgNetSceneProcessTask) {
        this.kgf = wepkgNetSceneProcessTask;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            try {
                d.Em().H(new 1(this, (oz) bVar.dIE.dIL));
                return;
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgVersionManager", "get checkwepkgversion error");
                return;
            }
        }
        x.e("MicroMsg.Wepkg.WepkgVersionManager", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        h.mEJ.a(859, 16, 1, false);
    }
}
