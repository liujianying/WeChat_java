package c.t.m.g;

import android.content.IntentFilter;

class dm$2 implements Runnable {
    private /* synthetic */ dm a;

    dm$2(dm dmVar) {
        this.a = dmVar;
    }

    public final void run() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        try {
            if (dm.c(this.a) != null) {
                dm.d(this.a).a.registerReceiver(this.a, intentFilter, null, dm.c(this.a));
            } else {
                dm.d(this.a).a.registerReceiver(this.a, intentFilter);
            }
        } catch (Exception e) {
        }
    }
}
