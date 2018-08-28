package com.tencent.tencentmap.mapsdk.a;

class cf$3 implements Runnable {
    private /* synthetic */ ce a;
    private /* synthetic */ int b;

    cf$3(ce ceVar, int i) {
        this.a = ceVar;
        this.b = i;
    }

    public final void run() {
        this.a.a();
        if (this.b >= 3) {
            ct.e("query finished should notify", new Object[0]);
            this.a.b();
        }
    }
}
