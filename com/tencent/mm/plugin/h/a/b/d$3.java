package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ d hgl;

    d$3(d dVar) {
        this.hgl = dVar;
    }

    public final void run() {
        x.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
        if (3 == this.hgl.hgj) {
            x.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
            return;
        }
        this.hgl.mHandler.removeCallbacks(this.hgl.hgf);
        this.hgl.hgj = 2;
        if (this.hgl.hfZ != null) {
            this.hgl.hfZ.hfE.i(this.hgl.mSessionId, false);
        }
    }
}
