package com.tencent.mm.plugin.appbrand.page;

class n$12 implements Runnable {
    final /* synthetic */ n gmP;
    final /* synthetic */ boolean gnb;
    final /* synthetic */ String val$url;

    n$12(n nVar, String str, boolean z) {
        this.gmP = nVar;
        this.val$url = str;
        this.gnb = z;
    }

    public final void run() {
        n.a(this.gmP, this.val$url, this.gnb ? aa.gpk : aa.gpj);
    }
}
