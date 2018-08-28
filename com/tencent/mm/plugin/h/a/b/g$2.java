package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.h.a.b.g.a;

class g$2 implements Runnable {
    final /* synthetic */ byte[] hfN;
    final /* synthetic */ int hfm;
    final /* synthetic */ BluetoothDevice hfp;
    final /* synthetic */ g hgL;

    g$2(g gVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.hgL = gVar;
        this.hfp = bluetoothDevice;
        this.hfm = i;
        this.hfN = bArr;
    }

    public final void run() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < g.a(this.hgL).size()) {
                ((a) g.a(this.hgL).get(i2)).b(this.hfp, this.hfm, this.hfN);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
