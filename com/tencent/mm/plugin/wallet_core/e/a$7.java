package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class a$7 implements e {
    final /* synthetic */ a pAV;
    final /* synthetic */ Context val$context;

    a$7(a aVar, Context context) {
        this.pAV = aVar;
        this.val$context = context;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Ek();
        g.Eh().dpP.b(1650, this);
        this.pAV.pAT = null;
        if (this.pAV.pAU != null) {
            this.pAV.b(this.val$context, this.pAV.pAU);
            this.pAV.pAU = null;
        }
    }
}
