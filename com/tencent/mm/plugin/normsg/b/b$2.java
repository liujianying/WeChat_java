package com.tencent.mm.plugin.normsg.b;

import android.view.View;

class b$2 implements Runnable {
    final /* synthetic */ int bAM;
    final /* synthetic */ boolean[] lGA;
    final /* synthetic */ b lGB;
    final /* synthetic */ int lGx;
    final /* synthetic */ View lGy;

    b$2(b bVar, boolean[] zArr, int i, int i2, View view) {
        this.lGB = bVar;
        this.lGA = zArr;
        this.bAM = i;
        this.lGx = i2;
        this.lGy = view;
    }

    public final void run() {
        this.lGA[0] = b.b(this.lGB, this.bAM, this.lGx, this.lGy);
        synchronized (this.lGA) {
            this.lGA[1] = true;
            this.lGA.notifyAll();
        }
    }
}
