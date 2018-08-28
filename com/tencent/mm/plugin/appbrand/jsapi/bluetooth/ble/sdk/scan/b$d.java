package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
class b$d extends ScanCallback {
    private final WeakReference<e> fMZ;

    b$d(e eVar) {
        this.fMZ = new WeakReference(eVar);
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        e eVar = (e) this.fMZ.get();
        if (eVar != null) {
            eVar.a(i, new ScanResultCompat(scanResult));
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        if (((e) this.fMZ.get()) != null) {
            List arrayList = new ArrayList(list.size());
            for (ScanResult scanResultCompat : list) {
                arrayList.add(new ScanResultCompat(scanResultCompat));
            }
        }
    }

    public final void onScanFailed(int i) {
        e eVar = (e) this.fMZ.get();
        if (eVar != null) {
            eVar.onScanFailed(i);
        }
    }
}
