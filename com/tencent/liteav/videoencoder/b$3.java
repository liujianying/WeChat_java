package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.d.b;
import com.tencent.liteav.basic.d.d;

class b$3 implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ b b;
    final /* synthetic */ b c;

    b$3(b bVar, d dVar, b bVar2) {
        this.c = bVar;
        this.a = dVar;
        this.b = bVar2;
    }

    public void run() {
        if (this.a != null) {
            this.a.d();
        }
        if (this.b != null) {
            this.b.b();
        }
    }
}
