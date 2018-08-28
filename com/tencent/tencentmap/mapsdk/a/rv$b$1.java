package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.rv.b;
import com.tencent.tencentmap.mapsdk.a.tc.a;

class rv$b$1 extends Thread {
    private /* synthetic */ boolean a;
    private /* synthetic */ boolean b;

    rv$b$1(b bVar, boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final void run() {
        if (this.a) {
            te.a().a(a.a);
        }
        if (this.b) {
            te.a().a(a.c);
        }
    }
}
