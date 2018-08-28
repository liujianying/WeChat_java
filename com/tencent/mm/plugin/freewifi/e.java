package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class e {
    private Activity activity;
    private WifiManager bnh = ((WifiManager) ad.getContext().getSystemService("wifi"));
    Condition bvW = this.jhz.newCondition();
    private BroadcastReceiver jhC;
    private int jhL = 10;
    Lock jhz = new ReentrantLock();

    public e(Activity activity) {
        this.activity = activity;
    }

    public final int aNQ() {
        if (3 == this.bnh.getWifiState()) {
            return 0;
        }
        this.jhC = new 1(this);
        try {
            this.jhz.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.activity.registerReceiver(this.jhC, intentFilter);
            this.bnh.setWifiEnabled(true);
            if (this.bvW.await((long) this.jhL, TimeUnit.SECONDS)) {
                return 0;
            }
            aNO();
            this.jhz.unlock();
            return 1;
        } catch (InterruptedException e) {
            return 2;
        } finally {
            aNO();
            this.jhz.unlock();
            return 2;
        }
    }

    public final void aNO() {
        try {
            this.activity.unregisterReceiver(this.jhC);
        } catch (IllegalArgumentException e) {
        }
    }
}
