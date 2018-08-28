package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import java.util.Iterator;

class k$7 implements Runnable {
    final /* synthetic */ k gAU;

    k$7(k kVar) {
        this.gAU = kVar;
    }

    public final void run() {
        Iterator it = this.gAU.gAR.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            k kVar = this.gAU;
            ai U = z.U(dVar.SU);
            kVar.gAS.add(dVar);
            U.v(0.0f).h(kVar.RX).a(new k$8(kVar, dVar, U)).start();
        }
        this.gAU.gAR.clear();
    }
}
