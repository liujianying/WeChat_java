package com.tencent.mm.view.e;

class a$3 implements Runnable {
    final /* synthetic */ String igj;
    final /* synthetic */ a uWa;

    public a$3(a aVar, String str) {
        this.uWa = aVar;
        this.igj = str;
    }

    public final void run() {
        if (a.c(this.uWa) != null && a.d(this.uWa) != null && a.d(this.uWa).abS(this.igj) != null) {
            a.a(this.uWa, a.d(this.uWa).abS(this.igj).gKG);
            a.c(this.uWa).setCurrentItem(a.e(this.uWa));
            a.d(this.uWa).uWt = 0;
        }
    }
}
