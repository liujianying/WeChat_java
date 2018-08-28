package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;

class ExdeviceManageDeviceUI$a$6 implements Runnable {
    final /* synthetic */ a iDr;

    ExdeviceManageDeviceUI$a$6(a aVar) {
        this.iDr = aVar;
    }

    public final void run() {
        a.a(this.iDr).remove(a.d(this.iDr));
        this.iDr.notifyDataSetChanged();
        a.a(this.iDr, -1);
    }
}
