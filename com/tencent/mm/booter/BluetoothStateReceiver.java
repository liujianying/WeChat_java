package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

public class BluetoothStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.getState() == 12) {
                h.mEJ.h(11921, new Object[]{Integer.valueOf(1)});
            } else if (defaultAdapter.getState() == 10) {
                h.mEJ.h(11921, new Object[]{Integer.valueOf(0)});
            }
            new StringBuilder("[oneliang]bluetoothAdapter state:").append(defaultAdapter.getState());
        }
    }
}
