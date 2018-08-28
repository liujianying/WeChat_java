package com.tencent.mm.plugin.card.b;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.plugin.card.b.i.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class i$a$3 implements LeScanCallback {
    final /* synthetic */ a hux;

    i$a$3(a aVar) {
        this.hux = aVar;
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice == null) {
            x.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
        } else if (this.hux.huq.hui != null && !bi.oW(this.hux.huq.hui.name)) {
            String oV = bi.oV(bluetoothDevice.getName());
            String address = bluetoothDevice.getAddress();
            if (oV.equals(this.hux.huq.hui.name)) {
                x.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[]{address, oV, Integer.valueOf(i)});
                this.hux.hut.put(address, new b(address, i, oV, a.ah(bArr)));
                return;
            }
            x.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", new Object[]{address, oV, Integer.valueOf(i)});
        }
    }
}
