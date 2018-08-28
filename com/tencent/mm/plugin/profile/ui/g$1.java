package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;

class g$1 implements a {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;
    final /* synthetic */ p hlF;

    g$1(boolean z, p pVar) {
        this.hlD = z;
        this.hlF = pVar;
    }

    public final boolean vD() {
        int i;
        int GQ = q.GQ();
        if (this.hlD) {
            i = GQ & -32769;
        } else {
            i = GQ | 32768;
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            g.acV();
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
        if (this.hlF != null) {
            this.hlF.dismiss();
        }
        return true;
    }
}
