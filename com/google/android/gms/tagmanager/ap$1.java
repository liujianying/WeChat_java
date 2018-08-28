package com.google.android.gms.tagmanager;

import java.util.List;

class ap$1 implements Runnable {
    final /* synthetic */ List bda;
    final /* synthetic */ long bdb;
    final /* synthetic */ ap bdc;

    ap$1(ap apVar, List list, long j) {
        this.bdc = apVar;
        this.bda = list;
        this.bdb = j;
    }

    public final void run() {
        ap.a(this.bdc, this.bda, this.bdb);
    }
}
