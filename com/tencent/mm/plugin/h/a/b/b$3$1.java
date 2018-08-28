package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.b.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ byte[] hfN;
    final /* synthetic */ 3 hfP;
    final /* synthetic */ int hfm;
    final /* synthetic */ BluetoothDevice hfp;

    b$3$1(3 3, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.hfP = 3;
        this.hfp = bluetoothDevice;
        this.hfm = i;
        this.hfN = bArr;
    }

    public final void run() {
        b.a(this.hfP.hfM, this.hfp, this.hfm, this.hfN);
    }
}
