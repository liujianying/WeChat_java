package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {
    Activity activity;
    private WifiManager bnh;
    Condition bvW;
    private long dJH;
    boolean jhA = false;
    boolean jhB = false;
    private BroadcastReceiver jhC;
    Lock jhz;
    String ssid;

    public a(String str, Activity activity) {
        this.activity = activity;
        this.dJH = 15000;
        this.ssid = str;
        this.jhz = new ReentrantLock();
        this.bvW = this.jhz.newCondition();
        this.bnh = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
    }

    public final void a(a aVar) {
        1 1 = new 1(this, aVar);
        if (((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.aOC())) {
            1.onSuccess();
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        } else {
            this.jhC = new 2(this);
            try {
                int aNQ;
                this.jhz.lock();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.activity.registerReceiver(this.jhC, intentFilter);
                if (!this.bnh.isWifiEnabled()) {
                    aNQ = new e(this.activity).aNQ();
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aNQ);
                    if (aNQ != 0) {
                        1.pT(aNQ);
                        aNO();
                        this.jhz.unlock();
                        return;
                    }
                }
                aNQ = d.BZ(this.ssid);
                if (aNQ != 0) {
                    aNO();
                    1.pT(aNQ);
                    aNO();
                    this.jhz.unlock();
                    return;
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
                if (z) {
                    1.onSuccess();
                } else {
                    1.pT(-16);
                }
                aNO();
                this.jhz.unlock();
            } catch (InterruptedException e) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{m.E(this.activity.getIntent()), Integer.valueOf(m.F(this.activity.getIntent())), e.getMessage()});
                1.pT(-17);
                aNO();
                this.jhz.unlock();
            } catch (Throwable th) {
                aNO();
                this.jhz.unlock();
                throw th;
            }
        }
    }

    private void aNO() {
        try {
            this.activity.unregisterReceiver(this.jhC);
        } catch (IllegalArgumentException e) {
        }
    }
}
