package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a;
import com.tencent.mm.protocal.c.alx;

class ExdeviceManageDeviceUI$a$4 implements Runnable {
    final /* synthetic */ a iDr;
    final /* synthetic */ b iDs;

    ExdeviceManageDeviceUI$a$4(a aVar, b bVar) {
        this.iDr = aVar;
        this.iDs = bVar;
    }

    public final void run() {
        alx alx = new alx();
        alx.hbO = this.iDs.field_deviceID;
        alx.reT = this.iDs.field_deviceType;
        au.DF().a(new x(alx, 2), 0);
    }
}
