package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.c.c.a;

class ap$2 implements Runnable {
    final /* synthetic */ ap bdc;
    final /* synthetic */ a bdd;

    ap$2(ap apVar, a aVar) {
        this.bdc = apVar;
        this.bdd = aVar;
    }

    public final void run() {
        this.bdd.v(ap.a(this.bdc));
    }
}
