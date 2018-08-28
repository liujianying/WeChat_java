package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.m.b;

class m$1 implements Runnable {
    final /* synthetic */ String bpQ;
    final /* synthetic */ boolean jLW = true;
    final /* synthetic */ m jLX;
    final /* synthetic */ int val$event;

    m$1(m mVar, int i, String str) {
        this.jLX = mVar;
        this.val$event = i;
        this.bpQ = str;
    }

    public final void run() {
        synchronized (m.aTR()) {
            for (b f : m.aTR()) {
                f.f(this.val$event, this.bpQ, this.jLW);
            }
        }
    }
}
