package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.g.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ b hfM;

    b$3(b bVar) {
        this.hfM = bVar;
    }

    public final void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        x.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(b.Az(bluetoothDevice.getAddress()))});
        this.hfM.mHandler.post(new 1(this, bluetoothDevice, i, bArr));
    }

    public final void nb(int i) {
        x.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[]{Integer.valueOf(i)});
        if (i != 1) {
            this.hfM.mHandler.post(new 2(this));
        }
    }
}
