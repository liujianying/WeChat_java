package com.d.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.d.a.a.d.a;

final class ab extends c {
    private static ab bna;
    WifiManager bgP;
    private final BroadcastReceiver bnb = new 1(this);
    private final IntentFilter bnc = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac bnd;
    private long bne = 10000;

    private ab() {
    }

    static ab sZ() {
        if (bna == null) {
            bna = new ab();
        }
        return bna;
    }

    private boolean isAvailable() {
        return this.bgP != null;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(10000);
        }
        super.a(handler, aVar);
    }

    final void aw(Context context) {
        this.bgP = (WifiManager) context.getSystemService("wifi");
    }

    final void a(Context context, Handler handler, a aVar) {
        if (isAvailable()) {
            context.registerReceiver(this.bnb, this.bnc, null, handler);
            this.bne = aVar.bgK;
            WifiManager wifiManager = this.bgP;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.bnd = new ac(wifiManager, handler);
            this.bnd.f(this.bne, 0);
        }
    }

    final void ax(Context context) {
        if (isAvailable()) {
            context.unregisterReceiver(this.bnb);
            this.bnd.stop();
        }
    }

    final void sr() {
    }

    final void ss() {
        if (isAvailable() && this.bgH && this.bne < 90000) {
            this.bnd.f(90000, 0);
        }
    }

    final void st() {
        if (isAvailable() && this.bgH && this.bne < 90000) {
            this.bnd.f(this.bne, 0);
        }
    }
}
