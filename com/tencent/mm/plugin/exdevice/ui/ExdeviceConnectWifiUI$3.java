package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$3 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$3(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final void run() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            byte[] f = e.f(stringBuilder.append(c.Gq()).append("exdevice_wifi_infos").toString(), 0, Integer.MAX_VALUE);
            if (f != null) {
                ExdeviceConnectWifiUI.o(this.iCh).aG(f);
                ExdeviceConnectWifiUI.p(this.iCh);
            }
        } catch (Throwable e) {
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        ah.i(new 1(this), 500);
    }
}
