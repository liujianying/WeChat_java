package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    private WifiManager bnh = ((WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI));
    Condition bvW = this.jhz.newCondition();
    private Context context;
    private BroadcastReceiver jhC;
    private int jhL = 10;
    Lock jhz = new ReentrantLock();

    public f(Context context) {
        this.context = context;
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
            this.context.registerReceiver(this.jhC, intentFilter);
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
            this.context.unregisterReceiver(this.jhC);
        } catch (IllegalArgumentException e) {
        }
    }
}
