package com.tencent.mm.plugin.exdevice.model;

import android.os.Build.VERSION;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.e.38;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$45 extends c<rh> {
    final /* synthetic */ e iup;

    e$45(e eVar) {
        this.iup = eVar;
        this.sFo = rh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e eVar = this.iup;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
        int Lg = au.DF().Lg();
        if (Lg == 4 || Lg == 6) {
            boolean z;
            String value = g.AT().getValue("DeviceAutoSyncClose");
            x.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[]{value});
            if (bi.oW(value) || !value.equalsIgnoreCase("1")) {
                z = true;
            } else {
                x.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                z = false;
            }
            if (!z) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                return false;
            } else if (!a.cT(ad.getContext())) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                return false;
            } else if (a.atY()) {
                ad.aHl();
                if (d.aGM() == 1) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                    return false;
                } else if (i.ivn.ex(false)) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                    i.ivn.a(null, new 38(eVar));
                    return true;
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                    return e.aGO();
                }
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                return false;
            }
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[]{Integer.valueOf(Lg)});
        return false;
    }
}
