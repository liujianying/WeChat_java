package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.b.b.2;

class b$2$1 implements Runnable {
    final /* synthetic */ byte[] hfN;
    final /* synthetic */ 2 hfO;
    final /* synthetic */ int hfm;
    final /* synthetic */ BluetoothDevice hfp;

    b$2$1(2 2, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.hfO = 2;
        this.hfp = bluetoothDevice;
        this.hfm = i;
        this.hfN = bArr;
    }

    public final void run() {
        b.a(this.hfO.hfM, this.hfp, this.hfm, this.hfN);
    }
}
