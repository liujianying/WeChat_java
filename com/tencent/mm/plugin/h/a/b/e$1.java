package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.b.a.c;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements c$a {
    final /* synthetic */ e hgr;

    e$1(e eVar) {
        this.hgr = eVar;
    }

    public final void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        long Az = b.Az(bluetoothDevice.getAddress());
        if (!this.hgr.hgo.contains(Long.valueOf(Az))) {
            x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(Az), b.aq(bArr)});
            this.hgr.hgo.add(Long.valueOf(Az));
            if (c.ae(bArr)) {
                this.hgr.hgn.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
            }
        }
    }

    public final void atO() {
        x.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
        if (this.hgr.hgn != null) {
            this.hgr.hgn.atO();
        } else {
            x.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
        }
        this.hgr.hgo.clear();
    }
}
