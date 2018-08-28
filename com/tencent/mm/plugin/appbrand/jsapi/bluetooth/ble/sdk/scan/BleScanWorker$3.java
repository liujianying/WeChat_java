package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a;
import com.tencent.mm.sdk.platformtools.x;

class BleScanWorker$3 extends BroadcastReceiver {
    final /* synthetic */ a fMV;

    public BleScanWorker$3(a aVar) {
        this.fMV = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.i("MicroMsg.Ble.BleScanWorker", "Receive intent failed");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            x.d("MicroMsg.Ble.BleScanWorker", "state:%d", new Object[]{Integer.valueOf(state)});
            if (state != 12 && state != 11) {
                if (state == 10 || state == 13) {
                    a.i("MicroMsg.Ble.BleScanWorker", "bluetooth is disable, stop scan", new Object[0]);
                    this.fMV.fMQ.set(false);
                    this.fMV.aiw();
                }
            }
        }
    }
}
