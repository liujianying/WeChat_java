package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

class j$1 implements Runnable {
    final /* synthetic */ j qoy;

    j$1(j jVar) {
        this.qoy = jVar;
    }

    public final void run() {
        j.a(this.qoy);
        this.qoy.cR(this.qoy.qnE.msv);
        if (k.caj() != null) {
            k.can();
        }
    }

    public final String toString() {
        return super.toString() + "|dealWNoteInfo";
    }
}
