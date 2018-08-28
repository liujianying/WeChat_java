package com.tencent.mm.plugin.appbrand.page;

class n$8 implements Runnable {
    final /* synthetic */ n gmP;
    final /* synthetic */ String gmX;
    final /* synthetic */ String gmY;
    final /* synthetic */ int[] gmZ;

    n$8(n nVar, String str, String str2, int[] iArr) {
        this.gmP = nVar;
        this.gmX = str;
        this.gmY = str2;
        this.gmZ = iArr;
    }

    public final void run() {
        n.a(this.gmP, this.gmX, this.gmY, this.gmZ);
    }
}
