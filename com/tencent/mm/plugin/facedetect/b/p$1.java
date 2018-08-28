package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.modelsimple.i;

class p$1 implements Runnable {
    final /* synthetic */ int dRC;
    final /* synthetic */ p iMH;

    p$1(p pVar, int i) {
        this.iMH = pVar;
        this.dRC = i;
    }

    public final void run() {
        new i().a(p.a(this.iMH), new 1(this));
    }
}
