package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.c.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b hfM;

    b$2(b bVar) {
        this.hfM = bVar;
    }

    public final void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(b.Az(bluetoothDevice.getAddress()))});
        this.hfM.mHandler.post(new 1(this, bluetoothDevice, i, bArr));
    }

    public final void atO() {
    }
}
