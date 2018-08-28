package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.r;

class i$2 implements a {
    final /* synthetic */ ProgressDialog hZo;
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;

    i$2(ProgressDialog progressDialog, boolean z) {
        this.hZo = progressDialog;
        this.hlD = z;
    }

    public final boolean vD() {
        if (this.hZo != null) {
            this.hZo.dismiss();
        }
        int GQ = q.GQ();
        if (this.hlD) {
            GQ &= -16777217;
        } else {
            GQ |= 16777216;
            au.HU();
            c.DT().set(286722, "");
            au.HU();
            c.DT().set(286721, "");
            au.HU();
            c.DT().set(286723, "");
        }
        au.HU();
        c.DT().set(34, Integer.valueOf(GQ));
        bay bay = new bay();
        bay.raB = 16777216;
        bay.sdm = this.hlD ? 0 : 1;
        au.HU();
        c.FQ().b(new h.a(39, bay));
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
        return false;
    }
}
