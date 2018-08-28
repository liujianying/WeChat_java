package com.google.android.gms.c;

import java.util.Iterator;

class ah$1 implements Runnable {
    final /* synthetic */ ae aYq;
    final /* synthetic */ ah aYr;

    public ah$1(ah ahVar, ae aeVar) {
        this.aYr = ahVar;
        this.aYq = aeVar;
    }

    public final void run() {
        this.aYq.aXY.a(this.aYq);
        Iterator it = ah.a(this.aYr).iterator();
        while (it.hasNext()) {
            it.next();
        }
        ah.d(this.aYq);
    }
}
