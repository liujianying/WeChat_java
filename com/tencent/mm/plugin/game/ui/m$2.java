package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

class m$2 implements Runnable {
    final /* synthetic */ LinkedList jZY;
    final /* synthetic */ m jZZ;

    m$2(m mVar, LinkedList linkedList) {
        this.jZZ = mVar;
        this.jZY = linkedList;
    }

    public final void run() {
        m.a(this.jZZ, this.jZY);
        ah.A(new 1(this));
    }
}
