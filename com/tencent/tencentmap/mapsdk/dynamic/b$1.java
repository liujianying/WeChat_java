package com.tencent.tencentmap.mapsdk.dynamic;

class b$1 implements Runnable {
    final /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public void run() {
        boolean z = true;
        if (!b.c()) {
            b.b(true);
            b bVar = this.a;
            if (b.a(this.a)) {
                z = false;
            }
            bVar.a(z);
            b.b(false);
        }
    }
}
