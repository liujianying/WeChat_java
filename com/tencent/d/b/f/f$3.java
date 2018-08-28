package com.tencent.d.b.f;

class f$3 implements Runnable {
    final /* synthetic */ int pUV;
    final /* synthetic */ f vmz;

    public f$3(f fVar, int i) {
        this.vmz = fVar;
        this.pUV = i;
    }

    public final void run() {
        synchronized (f.a(this.vmz)) {
            d dVar = (d) f.CP().get(this.pUV);
            if (!(dVar == null || !(dVar instanceof a) || ((a) dVar).isCancelled())) {
                ((a) dVar).cFW();
            }
        }
    }
}
