package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    private WifiManager bnh;
    Condition bvW;
    private Context context;
    private long dJH = 15000;
    boolean jhA = false;
    boolean jhB = false;
    private BroadcastReceiver jhC;
    Lock jhz;
    String ssid;

    public b(String str, Context context) {
        this.ssid = str;
        this.jhz = new ReentrantLock();
        this.bvW = this.jhz.newCondition();
        this.bnh = (WifiManager) context.getSystemService("wifi");
        this.context = context;
    }

    public final int aNP() {
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aOC())) {
            return 0;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        }
        this.jhC = new 1(this);
        try {
            int aNQ;
            this.jhz.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.jhC, intentFilter);
            if (!this.bnh.isWifiEnabled()) {
                aNQ = new f(this.context).aNQ();
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aNQ);
                if (aNQ != 0) {
                    return aNQ;
                }
            }
            aNQ = d.BZ(this.ssid);
            if (aNQ != 0) {
                aNO();
                aNO();
                this.jhz.unlock();
                return aNQ;
            }
            boolean z = false;
            while (true) {
                if (!this.jhA || !this.jhB) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z = this.bvW.await(this.dJH, TimeUnit.MILLISECONDS);
                    if (!z) {
                        break;
                    }
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    this.dJH -= currentTimeMillis;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.dJH);
                    this.dJH = this.dJH > 0 ? this.dJH : 3000;
                } else {
                    break;
                }
            }
            if (!z) {
                return -16;
            }
            aNO();
            this.jhz.unlock();
            return 0;
        } catch (InterruptedException e) {
            x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{e.getMessage()});
            return -17;
        } finally {
            aNO();
            this.jhz.unlock();
            return -17;
        }
    }

    private void aNO() {
        try {
            this.context.unregisterReceiver(this.jhC);
        } catch (IllegalArgumentException e) {
        }
    }
}
