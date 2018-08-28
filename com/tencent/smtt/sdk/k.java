package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

final class k extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Handler b;

    k(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
    }

    public final void run() {
        if (an.a().a(true, this.a) == 0) {
            an.a().b(this.a, true);
        }
        o.a(true).a(this.a, false, false, null);
        bv a = bv.a();
        a.a(this.a, null);
        boolean b = a.b();
        this.b.sendEmptyMessage(3);
        if (b) {
            this.b.sendEmptyMessage(1);
        } else {
            this.b.sendEmptyMessage(2);
        }
    }
}
