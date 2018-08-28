package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.r;

class j$4 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;
    final /* synthetic */ Context val$context;

    j$4(boolean z, Context context) {
        this.hlD = z;
        this.val$context = context;
    }

    public final void handleMessage(Message message) {
        int i;
        if (this.hlD) {
            j.hc(true);
        }
        int GQ = q.GQ();
        if (this.hlD) {
            i = GQ & -17;
        } else {
            i = GQ | 16;
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            j.dZ(this.val$context);
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
