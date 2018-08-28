package com.tencent.mm.ak;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.sns.i$l;

class i$3 implements Runnable {
    final /* synthetic */ l bFp;
    final /* synthetic */ i dVa;

    i$3(i iVar, l lVar) {
        this.dVa = iVar;
        this.bFp = lVar;
    }

    public final void run() {
        if (this.bFp.getType() == i$l.AppCompatTheme_spinnerStyle && (this.bFp instanceof l)) {
            i.c(this.dVa);
            i.OR().remove(Integer.valueOf((int) ((l) this.bFp).dVh));
            if (i.d(this.dVa) > 0) {
                i.e(this.dVa);
            } else {
                i.f(this.dVa);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|onSceneEnd";
    }
}
