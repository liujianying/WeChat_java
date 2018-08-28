package com.tencent.mm.plugin.freewifi.e;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper.2;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.c$a;
import com.tencent.mm.plugin.freewifi.e;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class f$1 implements Runnable {
    final /* synthetic */ c jkK;
    final /* synthetic */ f jkL;

    f$1(f fVar, c cVar) {
        this.jkL = fVar;
        this.jkK = cVar;
    }

    public final void run() {
        c cVar = this.jkK;
        c$a c_1 = new c$1(cVar, new 1(this));
        if (((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected() && cVar.ssid.equals(d.aOC())) {
            c_1.onSuccess();
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        } else {
            cVar.jhC = new 2(cVar);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
            try {
                int aNQ;
                cVar.jhz.lock();
                cVar.activity.registerReceiver(cVar.jhC, intentFilter);
                if (!cVar.bnh.isWifiEnabled()) {
                    aNQ = new e(cVar.activity).aNQ();
                    x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "enable ret = " + aNQ);
                    if (aNQ != 0) {
                        c_1.pT(aNQ);
                        cVar.aNO();
                        cVar.jhz.unlock();
                        return;
                    }
                }
                aNQ = d.d(cVar.ssid, cVar.eSH, 3, false);
                if (aNQ != 0) {
                    cVar.aNO();
                    c_1.pT(aNQ);
                    cVar.aNO();
                    cVar.jhz.unlock();
                    return;
                }
                boolean await = (cVar.connected || cVar.jhG) ? false : cVar.bvW.await(cVar.dJH, TimeUnit.MILLISECONDS);
                if (!await) {
                    c_1.pT(-16);
                } else if (cVar.connected) {
                    c_1.onSuccess();
                } else if (cVar.jhG) {
                    c_1.pT(-18);
                }
                cVar.aNO();
                cVar.jhz.unlock();
            } catch (InterruptedException e) {
                x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{m.E(cVar.activity.getIntent()), Integer.valueOf(m.F(cVar.activity.getIntent())), e.getMessage()});
                c_1.pT(-17);
                cVar.aNO();
                cVar.jhz.unlock();
            } catch (Throwable th) {
                cVar.aNO();
                cVar.jhz.unlock();
                throw th;
            }
        }
    }
}
