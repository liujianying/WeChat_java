package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a;

class a$2 extends e {
    final /* synthetic */ a fMV;

    public a$2(a aVar) {
        this.fMV = aVar;
    }

    public final void a(int i, ScanResultCompat scanResultCompat) {
        int i2 = 0;
        if (scanResultCompat.getDevice() == null) {
            a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]result is null, err", new Object[0]);
        } else if (!this.fMV.fMR.get()) {
            a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]not init, err", new Object[0]);
        } else if (this.fMV.fMP == null) {
            a.w("MicroMsg.Ble.BleScanWorker", "[onScanResult]may be close, err", new Object[0]);
        } else {
            a.d("MicroMsg.Ble.BleScanWorker", "callbackType:%d, result:%s", new Object[]{Integer.valueOf(i), scanResultCompat});
            String address = scanResultCompat.getDevice().getAddress();
            if (!this.fMV.fMP.containsKey(address) || com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.fLu) {
                i2 = 1;
            }
            d dVar = new d(scanResultCompat);
            if (i2 != 0) {
                if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.fLt.djl > 0) {
                    if (this.fMV.fMS != null) {
                        this.fMV.fMS.add(dVar);
                    }
                } else if (this.fMV.fMU != null) {
                    this.fMV.fMU.a(dVar);
                }
            }
            this.fMV.fMP.put(address, dVar);
        }
    }

    public final void onScanFailed(int i) {
        a.e("MicroMsg.Ble.BleScanWorker", "[onScanResult]onScanFailed, errorCode:%d", new Object[]{Integer.valueOf(i)});
    }
}
