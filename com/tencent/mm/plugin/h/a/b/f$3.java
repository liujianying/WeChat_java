package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f hgG;

    f$3(f fVar) {
        this.hgG = fVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[]{b.cY(f.g(this.hgG)), f.h(this.hgG).getName()});
        if (3 == f.e(this.hgG)) {
            x.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
        } else if (f.e(this.hgG) == 1) {
            x.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
        } else {
            this.hgG.atS();
        }
    }
}
