package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.b;

class ExdeviceDeviceProfileUI$7 implements b {
    final /* synthetic */ ExdeviceDeviceProfileUI iCP;

    ExdeviceDeviceProfileUI$7(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.iCP = exdeviceDeviceProfileUI;
    }

    public final boolean p(CharSequence charSequence) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[]{charSequence});
        String str = "";
        if (charSequence != null) {
            str = charSequence.toString();
        }
        if (ExdeviceDeviceProfileUI.a(this.iCP)) {
            ExdeviceDeviceProfileUI.a(this.iCP, str);
            this.iCP.runOnUiThread(new 1(this));
            com.tencent.mm.plugin.exdevice.h.b cz = ad.aHe().cz(ExdeviceDeviceProfileUI.b(this.iCP), ExdeviceDeviceProfileUI.c(this.iCP));
            if (cz == null) {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[]{ExdeviceDeviceProfileUI.b(this.iCP), ExdeviceDeviceProfileUI.c(this.iCP)});
                return false;
            }
            cz.du(ExdeviceDeviceProfileUI.d(this.iCP));
            ad.aHe().c(cz, new String[0]);
        } else {
            y yVar = new y(ExdeviceDeviceProfileUI.b(this.iCP), ExdeviceDeviceProfileUI.c(this.iCP), str);
            ExdeviceDeviceProfileUI.a(this.iCP, yVar);
            au.DF().a(1263, this.iCP);
            au.DF().a(yVar, 0);
        }
        return true;
    }
}
