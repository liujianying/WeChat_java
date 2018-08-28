package com.tencent.mm.plugin.card.b;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class g$1 implements a {
    final /* synthetic */ g hua;

    g$1(g gVar) {
        this.hua = gVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g gVar = this.hua;
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (gVar.htB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gVar.htB.size()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) gVar.htB.get(i2);
                if (weakReference != null) {
                    g$a g_a = (g$a) weakReference.get();
                    if (g_a != null) {
                        g_a.awM();
                    }
                }
                i = i2 + 1;
            }
        }
        return true;
    }
}
