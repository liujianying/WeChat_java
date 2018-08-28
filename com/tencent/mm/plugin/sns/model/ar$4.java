package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class ar$4 implements Runnable {
    final /* synthetic */ f emR;
    final /* synthetic */ ar nrO;

    ar$4(ar arVar, f fVar) {
        this.nrO = arVar;
        this.emR = fVar;
    }

    public final void run() {
        String str = this.emR.bKW;
        synchronized (this.nrO.nrM) {
            Iterator it = this.nrO.nrM.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar != null && bi.fS(str, nVar.bBe())) {
                    x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[]{Integer.valueOf(this.nrO.hashCode()), str});
                    it.remove();
                }
            }
        }
        o.Tc().bT(false);
        if (this.nrO.emO != null) {
            this.nrO.emO.emp = null;
        }
        this.nrO.emO = null;
        this.nrO.byT();
        this.nrO.byR();
    }
}
