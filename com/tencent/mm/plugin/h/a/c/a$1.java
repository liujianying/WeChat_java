package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.h.a.c.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends BroadcastReceiver {
    final /* synthetic */ a hiK;

    a$1(a aVar) {
        this.hiK = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            x.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + action);
            BluetoothDevice bluetoothDevice;
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    this.hiK.hiH.bW(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                }
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                this.hiK.hiH.atO();
            } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                a aVar;
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1)) {
                    case 20:
                    case 21:
                        aVar = this.hiK.hiH;
                        return;
                    case 23:
                        aVar = this.hiK.hiH;
                        return;
                    default:
                        return;
                }
            } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                if (a.a(this.hiK).containsKey(Long.valueOf(b.Az(address)))) {
                    x.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice.getName(), address);
                    if (this.hiK.hiH != null) {
                        this.hiK.hiH.i(b.Az(address), false);
                    }
                }
            }
        }
    }
}
