package com.tencent.mm.plugin.card.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class c$2 implements a {
    final /* synthetic */ c htM;

    c$2(c cVar) {
        this.htM = cVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
        c cVar = this.htM;
        x.i("MicroMsg.CardCodeMgr", "onCodeChange()");
        if (cVar.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.htB.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) cVar.htB.get(i2);
                if (weakReference != null) {
                    c.a aVar = (c.a) weakReference.get();
                    if (aVar != null) {
                        aVar.awE();
                    }
                }
                i = i2 + 1;
            }
        }
        this.htM.awC();
        return true;
    }
}
