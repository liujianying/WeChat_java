package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.r;

class n$2 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    n$2(boolean z) {
        this.hlD = z;
    }

    public final void handleMessage(Message message) {
        int GQ = q.GQ();
        if (this.hlD) {
            GQ &= -33554433;
        } else {
            GQ |= 33554432;
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(GQ));
        bay bay = new bay();
        bay.raB = 33554432;
        bay.sdm = this.hlD ? 0 : 1;
        au.HU();
        c.FQ().b(new a(39, bay));
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
