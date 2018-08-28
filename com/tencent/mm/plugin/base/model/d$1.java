package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class d$1 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ String fFV;
    final /* synthetic */ d$a hdx;
    final /* synthetic */ Context val$context;

    d$1(d$a d_a, String str, Context context, String str2) {
        this.hdx = d_a;
        this.dhF = str;
        this.val$context = context;
        this.fFV = str2;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            au.HU();
            ab Yg = c.FR().Yg(this.dhF);
            if (Yg != null && !bi.oW(Yg.BK())) {
                d.a(this.val$context, this.dhF, this.fFV, Yg.BK(), this.hdx);
            } else if (this.hdx != null) {
                this.hdx.dF(false);
            }
        } else if (this.hdx != null) {
            this.hdx.dF(false);
        }
    }
}
