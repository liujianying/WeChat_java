package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.r.c;

class b$3 implements Runnable {
    final /* synthetic */ b ghq;
    final /* synthetic */ LaunchParcel ght;

    b$3(b bVar, LaunchParcel launchParcel) {
        this.ghq = bVar;
        this.ght = launchParcel;
    }

    public final void run() {
        c.aov();
        new com.tencent.mm.plugin.appbrand.launching.c(this.ght, new 1(this)).run();
    }
}
