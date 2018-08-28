package com.tencent.mm.plugin.profile.ui;

import android.os.Message;
import com.tencent.mm.aq.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.r;

class f$2 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    f$2(boolean z) {
        this.hlD = z;
    }

    public final void handleMessage(Message message) {
        int i;
        int GQ = q.GQ();
        if (this.hlD) {
            i = GQ & -8193;
        } else {
            i = GQ | 8192;
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(i));
        au.HU();
        c.FQ().b(new l("", "", "", "", "", "", "", "", i, "", ""));
        if (!this.hlD) {
            b.getFacebookFrdStg().Xw();
            au.HU();
            c.DT().set(65828, "");
            au.HU();
            c.FW().Yp("facebookapp");
            au.HU();
            c.FT().GK("facebookapp");
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
