package com.tencent.d.b.f;

class f$2 implements Runnable {
    final /* synthetic */ int pUV;
    final /* synthetic */ f vmz;

    f$2(f fVar, int i) {
        this.vmz = fVar;
        this.pUV = i;
    }

    public final void run() {
        synchronized (f.a(this.vmz)) {
            d dVar = (d) f.CP().get(this.pUV);
            if (dVar != null) {
                dVar.cFY();
            }
        }
    }
}
