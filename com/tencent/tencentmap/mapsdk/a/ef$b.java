package com.tencent.tencentmap.mapsdk.a;

import android.content.Intent;
import android.net.NetworkInfo;

class ef$b implements Runnable {
    private Intent a;
    private /* synthetic */ ef b;

    ef$b(ef efVar, Intent intent) {
        this.b = efVar;
        this.a = intent;
    }

    public final void run() {
        try {
            this.b.a((NetworkInfo) this.a.getParcelableExtra("networkInfo"));
        } catch (Throwable th) {
        }
    }
}
