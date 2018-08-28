package com.tencent.mm.plugin.appbrand.widget.input;

class u$5 implements Runnable {
    final /* synthetic */ u gIs;
    final /* synthetic */ int gIt;
    final /* synthetic */ boolean gIu;

    u$5(u uVar, int i, boolean z) {
        this.gIs = uVar;
        this.gIt = i;
        this.gIu = z;
    }

    public final void run() {
        int d = u.d(this.gIs);
        if (this.gIs.isShown()) {
            u.a(this.gIs, this.gIt);
        } else {
            u.a(this.gIs, 2);
        }
        if (u.e(this.gIs) != null && d != u.d(this.gIs) && !this.gIu) {
            u.e(this.gIs).kn(u.d(this.gIs));
        }
    }
}
