package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.b.c.a;

class c$2 implements Runnable {
    final /* synthetic */ byte[] hfN;
    final /* synthetic */ c hfW;
    final /* synthetic */ int hfm;
    final /* synthetic */ BluetoothDevice hfp;

    c$2(c cVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.hfW = cVar;
        this.hfp = bluetoothDevice;
        this.hfm = i;
        this.hfN = bArr;
    }

    public final void run() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < c.a(this.hfW).size()) {
                ((a) c.a(this.hfW).get(i2)).b(this.hfp, this.hfm, this.hfN);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
