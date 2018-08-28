package com.tencent.mm.plugin.h.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    final a hjb;
    public final BroadcastReceiver hjc = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                x.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
            } else if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                x.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    a.this.hjb.nc(intExtra);
                }
            }
        }
    };

    public a(a aVar) {
        x.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.hjb = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ad.getContext().registerReceiver(this.hjc, intentFilter);
    }
}
