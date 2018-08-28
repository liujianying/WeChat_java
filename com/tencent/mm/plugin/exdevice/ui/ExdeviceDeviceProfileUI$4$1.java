package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.4;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.p;

class ExdeviceDeviceProfileUI$4$1 implements a {
    final /* synthetic */ p hmi;
    final /* synthetic */ 4 iCQ;

    ExdeviceDeviceProfileUI$4$1(4 4, p pVar) {
        this.iCQ = 4;
        this.hmi = pVar;
    }

    public final boolean vD() {
        this.iCQ.iCP.runOnUiThread(new 1(this));
        return true;
    }
}
