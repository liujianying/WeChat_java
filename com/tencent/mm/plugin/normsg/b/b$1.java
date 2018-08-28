package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ boolean[] lGA;
    final /* synthetic */ b lGB;
    final /* synthetic */ int lGx;
    final /* synthetic */ View lGy;
    final /* synthetic */ List lGz;

    b$1(b bVar, int i, View view, List list, boolean[] zArr) {
        this.lGB = bVar;
        this.lGx = i;
        this.lGy = view;
        this.lGz = list;
        this.lGA = zArr;
    }

    public final void run() {
        b.b(this.lGB, this.lGx, this.lGy, this.lGz);
        synchronized (this.lGA) {
            this.lGA[0] = true;
            this.lGA.notifyAll();
        }
    }
}
