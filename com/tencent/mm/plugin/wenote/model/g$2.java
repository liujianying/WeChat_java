package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

class g$2 implements Runnable {
    final /* synthetic */ g qog;

    g$2(g gVar) {
        this.qog = gVar;
    }

    public final void run() {
        if (g.aTS().containsKey(g.b(this.qog))) {
            this.qog.qnE = (l) g.aTS().get(g.b(this.qog));
        } else {
            g.c(this.qog);
        }
        this.qog.cR(this.qog.qnE.msv);
        if (k.caj() != null) {
            k.can();
        }
    }

    public final String toString() {
        return super.toString() + "|dealWNoteInfo";
    }
}
