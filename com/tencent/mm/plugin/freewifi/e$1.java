package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends BroadcastReceiver {
    final /* synthetic */ e jhM;

    e$1(e eVar) {
        this.jhM = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("wifi_state", 0);
            x.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
            if (intExtra == 3) {
                try {
                    this.jhM.jhz.lock();
                    this.jhM.bvW.signalAll();
                } finally {
                    this.jhM.aNO();
                    this.jhM.jhz.unlock();
                }
            }
        }
    }
}
