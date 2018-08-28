package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.aq.g;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.r;

class e$3 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    e$3(boolean z) {
        this.hlD = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int i2;
        boolean z = this.hlD;
        int GJ = q.GJ();
        int GQ = q.GQ();
        if (z) {
            i = GJ | 4096;
            i2 = GQ & -65;
            au.HU();
            c.FQ().b(new g(11, 1));
        } else {
            i = GJ & -4097;
            i2 = GQ | 64;
            au.HU();
            c.FQ().b(new g(11, 2));
        }
        au.HU();
        c.DT().set(7, Integer.valueOf(i));
        au.HU();
        c.DT().set(34, Integer.valueOf(i2));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i2, "", ""));
        if (!this.hlD) {
            i.aul();
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
