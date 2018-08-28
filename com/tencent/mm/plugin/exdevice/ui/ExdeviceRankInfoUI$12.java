package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankInfoUI$12 implements b<j> {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$12(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        j jVar = (j) lVar;
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iFG.isFinishing() || ExdeviceRankInfoUI.d(this.iFG)) {
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
            return;
        }
        this.iFG.runOnUiThread(new 1(this));
        if (i == 0 && i2 == 0) {
            ExdeviceRankInfoUI.a(this.iFG, jVar.ixy);
            ExdeviceRankInfoUI.b(this.iFG, jVar.ixz);
            this.iFG.ixV = jVar.ixV;
            this.iFG.ixU = jVar.ixU;
            ExdeviceRankInfoUI.a(this.iFG, jVar.ixI);
            ExdeviceRankInfoUI.g(this.iFG);
            this.iFG.runOnUiThread(new 3(this));
        } else if (ExdeviceRankInfoUI.a(this.iFG) == null || ExdeviceRankInfoUI.a(this.iFG).size() == 0) {
            this.iFG.runOnUiThread(new 2(this));
        }
    }
}
