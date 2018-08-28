package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;

class ExdeviceProfileUI$15 implements b<g> {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$15(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            ExdeviceProfileUI.m(this.iEx);
            ExdeviceProfileUI.b(this.iEx);
            this.iEx.runOnUiThread(new 1(this));
        }
    }
}
