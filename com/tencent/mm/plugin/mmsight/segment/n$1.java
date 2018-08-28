package com.tencent.mm.plugin.mmsight.segment;

class n$1 implements Runnable {
    final /* synthetic */ int lmI;
    final /* synthetic */ int lmJ;
    final /* synthetic */ int lmK;
    final /* synthetic */ n lmL;

    n$1(n nVar, int i, int i2, int i3) {
        this.lmL = nVar;
        this.lmI = i;
        this.lmJ = i2;
        this.lmK = i3;
    }

    public final void run() {
        if (this.lmI <= n.a(this.lmL) * 2) {
            throw new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
        }
        n.b(this.lmL);
        n.a(this.lmL, this.lmJ);
        n.b(this.lmL, Math.min(this.lmI, this.lmL.getWidth() - (this.lmJ * 2)));
        n.c(this.lmL, Math.max(this.lmK, n.a(this.lmL) * 2));
        n.c(this.lmL).setBounds(this.lmJ, 0, this.lmJ + n.a(this.lmL), this.lmL.getHeight());
        n.e(this.lmL).setBounds((this.lmJ + n.d(this.lmL)) - n.a(this.lmL), 0, n.d(this.lmL) + this.lmJ, this.lmL.getHeight());
        if (n.f(this.lmL) == null && n.g(this.lmL) == null) {
            n.a(this.lmL, n.c(this.lmL).getBounds());
            n.b(this.lmL, n.e(this.lmL).getBounds());
        }
        this.lmL.invalidate();
    }
}
