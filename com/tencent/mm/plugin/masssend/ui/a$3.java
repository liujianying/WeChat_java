package com.tencent.mm.plugin.masssend.ui;

import android.os.Message;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.r;

class a$3 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    a$3(boolean z) {
        this.hlD = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int GQ = q.GQ();
        if (this.hlD) {
            i = GQ & -65537;
        } else {
            i = GQ | 65536;
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            a.acV();
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
