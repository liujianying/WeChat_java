package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.mp.4;

class mp$4$1 implements Runnable {
    final /* synthetic */ 4 a;

    mp$4$1(4 4) {
        this.a = 4;
    }

    public void run() {
        if (mp.a(this.a.b) != null && mp.a(this.a.b).p != null) {
            mp.a(this.a.b).p.a();
            mp.a(this.a.b).p = null;
        }
    }
}
