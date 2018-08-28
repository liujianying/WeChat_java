package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

class ExdeviceDeviceProfileUI$4 implements Runnable {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$4(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final void run() {
        Context context = this.iCP;
        this.iCP.getString(R.l.app_tip);
        new al(new 1(this, h.a(context, this.iCP.getString(R.l.exdevice_bound), false, null)), false).J(1000, 1000);
    }
}
