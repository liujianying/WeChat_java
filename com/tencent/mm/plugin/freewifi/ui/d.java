package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.freewifi.ui.c.1;
import com.tencent.mm.plugin.freewifi.ui.c.2;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static void xP() {
        try {
            c aPC = c.aPC();
            1 1 = new 1();
            if (!aPC.bgH) {
                aPC.bgH = true;
                aPC.jnm = c.OB();
                if (aPC.jnm == null) {
                    x.e(c.TAG, "doGeoLocation fail, iGetLocation is null");
                    return;
                }
                if (aPC.fRk == null) {
                    aPC.fRk = new 1(aPC, 1);
                }
                if (aPC.jnn == null) {
                    aPC.jnn = new ag(Looper.myLooper());
                }
                aPC.jnn.postDelayed(new 2(aPC), 20000);
                aPC.jnm.a(aPC.fRk);
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
        }
    }
}
