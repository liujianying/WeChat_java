package com.tencent.mm.app;

import android.content.ComponentName;
import android.os.IBinder;

class e$1 implements Runnable {
    final /* synthetic */ ComponentName byj;
    final /* synthetic */ IBinder byk;
    final /* synthetic */ e byl;

    e$1(e eVar, ComponentName componentName, IBinder iBinder) {
        this.byl = eVar;
        this.byj = componentName;
        this.byk = iBinder;
    }

    public final void run() {
        e.a(this.byl, this.byk);
    }
}
