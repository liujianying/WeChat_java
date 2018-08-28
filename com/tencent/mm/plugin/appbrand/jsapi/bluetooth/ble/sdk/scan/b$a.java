package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.support.v4.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.b.b;
import java.util.List;

@TargetApi(18)
class b$a implements b$e {
    static final j<e, b> fMX = new j();

    b$a() {
    }

    public final boolean a(BluetoothAdapter bluetoothAdapter, List<ScanFilterCompat> list, ScanSettingsCompat scanSettingsCompat, e eVar) {
        LeScanCallback leScanCallback = (b) fMX.get(eVar);
        if (leScanCallback == null) {
            leScanCallback = new b(list, eVar);
            fMX.put(eVar, leScanCallback);
        }
        return bluetoothAdapter.startLeScan(leScanCallback);
    }

    public final boolean a(BluetoothAdapter bluetoothAdapter, e eVar) {
        b bVar = (b) fMX.remove(eVar);
        if (bVar == null) {
            return false;
        }
        bluetoothAdapter.stopLeScan(bVar);
        return true;
    }
}
