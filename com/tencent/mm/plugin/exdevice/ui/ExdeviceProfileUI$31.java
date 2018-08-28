package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceProfileUI$31 implements b<h> {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$31(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.iEx.finish();
        }
    }
}
