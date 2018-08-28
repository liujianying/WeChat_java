package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceProfileUI$1 implements b<i> {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$1(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        i iVar = (i) lVar;
        if (this.iEx.isFinishing() || ExdeviceProfileUI.a(this.iEx)) {
            ExdeviceProfileUI.b(this.iEx);
            x.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
            return;
        }
        ExdeviceProfileUI.c(this.iEx);
        if (i == 0 && i2 == 0 && iVar != null) {
            this.iEx.runOnUiThread(new 1(this, iVar));
            ExdeviceProfileUI.a(this.iEx, iVar.ixC);
            ExdeviceProfileUI.a(this.iEx, iVar.ixy);
            ExdeviceProfileUI.b(this.iEx, iVar.ixz);
            ExdeviceProfileUI.a(this.iEx, ExdeviceProfileUI.aT(iVar.ixA));
            ExdeviceProfileUI.a(this.iEx, iVar.ixG);
            ExdeviceProfileUI.b(this.iEx, iVar.ixF);
            ExdeviceProfileUI.c(this.iEx, iVar.ixE);
            ExdeviceProfileUI.a(this.iEx, iVar.ixH);
            ExdeviceProfileUI.b(this.iEx, iVar.ixI);
            ExdeviceProfileUI.c(this.iEx, iVar.ixv);
            this.iEx.runOnUiThread(new 2(this));
            if (!ExdeviceProfileUI.h(this.iEx)) {
                ExdeviceProfileUI exdeviceProfileUI = this.iEx;
                ExdeviceProfileUI.i(this.iEx);
                ExdeviceProfileUI.j(exdeviceProfileUI);
            }
            this.iEx.runOnUiThread(new 3(this));
            ExdeviceProfileUI.m(this.iEx);
            ExdeviceProfileUI.b(this.iEx);
        }
    }
}
