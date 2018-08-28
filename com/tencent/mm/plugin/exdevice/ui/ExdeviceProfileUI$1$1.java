package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.1;

class ExdeviceProfileUI$1$1 implements Runnable {
    final /* synthetic */ i iEy;
    final /* synthetic */ 1 iEz;

    ExdeviceProfileUI$1$1(1 1, i iVar) {
        this.iEz = 1;
        this.iEy = iVar;
    }

    public final void run() {
        if (ExdeviceProfileUI.d(this.iEz.iEx) != null) {
            ExdeviceProfileUI.d(this.iEz.iEx).dismiss();
        }
        ExdeviceProfileUI.a(this.iEz.iEx, this.iEy.ixD);
        ExdeviceProfileUI.f(this.iEz.iEx).setAffectedUserInfo(ExdeviceProfileUI.e(this.iEz.iEx));
    }
}
