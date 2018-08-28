package com.tencent.tencentmap.mapsdk.a;

class tq$a implements Runnable {
    private boolean a = true;
    private int b = 60000;
    private /* synthetic */ tq c;

    public tq$a(tq tqVar, int i) {
        this.c = tqVar;
    }

    public final void a(boolean z) {
        this.a = false;
    }

    public final void run() {
        tq.a(this.c).a(false, false);
        if (this.a) {
            tq.b(this.c).postDelayed(this, (long) this.b);
        }
    }
}
