package com.tencent.mm.modelmulti;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements Runnable {
    final /* synthetic */ int eaV;
    final /* synthetic */ int eaW;

    r$1(int i, int i2) {
        this.eaV = i;
        this.eaW = i2;
    }

    public final void run() {
        r.vg();
        r.mp(e.bnE + "/testaddmsg.txt");
        if (r.PR().size() <= 0 || r.PS().size() <= 0) {
            x.e("MicroMsg.TestSyncAddMsg", "syncAddMsg get source failed cmd:%d contact:%d", new Object[]{Integer.valueOf(r.PS().size()), Integer.valueOf(r.PR().size())});
            return;
        }
        new al(au.Em().lnJ.getLooper(), new 1(this), true).J(3000, 3000);
    }
}
