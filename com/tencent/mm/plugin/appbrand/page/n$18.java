package com.tencent.mm.plugin.appbrand.page;

class n$18 implements Runnable {
    final /* synthetic */ n gmP;
    final /* synthetic */ l gmR;

    n$18(n nVar, l lVar) {
        this.gmP = nVar;
        this.gmR = lVar;
    }

    public final void run() {
        n.a(this.gmP, n.a(this.gmP).indexOf(this.gmR) + 1);
    }
}
