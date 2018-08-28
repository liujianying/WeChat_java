package com.tencent.mm.plugin.h.a.a;

import android.bluetooth.BluetoothDevice;

class f$9 implements Runnable {
    final /* synthetic */ f hfj;
    final /* synthetic */ int hfm;
    final /* synthetic */ e hfo;
    final /* synthetic */ BluetoothDevice hfp;

    f$9(f fVar, int i, BluetoothDevice bluetoothDevice, e eVar) {
        this.hfj = fVar;
        this.hfm = i;
        this.hfp = bluetoothDevice;
        this.hfo = eVar;
    }

    public final void run() {
        f.d(this.hfj).a(this.hfm, this.hfp.getAddress(), this.hfo);
    }
}
