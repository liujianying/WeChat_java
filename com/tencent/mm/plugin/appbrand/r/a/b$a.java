package com.tencent.mm.plugin.appbrand.r.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b$a extends BroadcastReceiver {
    final /* synthetic */ b gCo;

    private b$a(b bVar) {
        this.gCo = bVar;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final void onReceive(Context context, Intent intent) {
        synchronized (this.gCo.gCm) {
            this.gCo.gCl = intent;
        }
    }
}
