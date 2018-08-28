package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class a$a {
    volatile boolean bTv = false;
    BluetoothAdapter fQu;
    Map<String, JSONObject> fQv = new HashMap();
    UUID[] fQw = null;
    a fQx;
    LeScanCallback fQy = new 1(this);

    public a$a() {
        BluetoothManager bluetoothManager = (BluetoothManager) ad.getContext().getSystemService("bluetooth");
        if (bluetoothManager == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
            return;
        }
        this.fQu = bluetoothManager.getAdapter();
        if (this.fQu == null) {
            x.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
        } else {
            a.fLa = this.fQu.isEnabled();
        }
    }

    final synchronized boolean aiS() {
        return this.bTv;
    }

    public final boolean wk() {
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[]{Integer.valueOf(hashCode())});
        if (aiS()) {
            this.fQv.clear();
            this.fQu.stopLeScan(this.fQy);
            this.bTv = false;
            return true;
        }
        x.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[]{Integer.valueOf(hashCode())});
        return false;
    }
}
