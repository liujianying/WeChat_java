package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$5 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$5(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI, l lVar) {
        this.iCP = exdeviceDeviceProfileUI;
        this.bFp = lVar;
    }

    public final void run() {
        ExdeviceDeviceProfileUI.a(this.iCP, h.a(this.iCP.mController.tml, this.iCP.getString(R.l.app_waiting), true, new 1(this)));
    }
}
