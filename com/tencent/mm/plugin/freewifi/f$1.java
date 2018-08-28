package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class f$1 extends BroadcastReceiver {
    final /* synthetic */ f jhN;

    f$1(f fVar) {
        this.jhN = fVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("wifi_state", 0);
            x.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
            if (intExtra == 3) {
                try {
                    this.jhN.jhz.lock();
                    this.jhN.bvW.signalAll();
                } finally {
                    this.jhN.aNO();
                    this.jhN.jhz.unlock();
                }
            }
        }
    }
}
