package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.k;

class ExdeviceProfileUI$17 implements b<k> {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$17(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        k kVar = (k) lVar;
        if (i == 0 && i2 == 0) {
            ExdeviceProfileUI.d(this.iEx, kVar.iya);
            ExdeviceProfileUI.e(this.iEx, kVar.ixY);
            ExdeviceProfileUI.f(this.iEx, kVar.ixZ);
            this.iEx.runOnUiThread(new 1(this));
            ExdeviceProfileUI.E(this.iEx);
        }
    }
}
