package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.k.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.notification.a.a.1;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ab;

class a$1$1 implements Runnable {
    final /* synthetic */ String lHl;
    final /* synthetic */ 1 lHm;

    a$1$1(1 1, String str) {
        this.lHm = 1;
        this.lHl = str;
    }

    public final void run() {
        int i = 0;
        int AQ = f.AQ();
        au.HU();
        ab Yg = c.FR().Yg(this.lHl);
        boolean BD = Yg == null ? false : Yg.BD();
        if (!BD) {
            i = f.fo(this.lHl);
        }
        ah.A(new 1(this, AQ, BD, i));
    }
}
