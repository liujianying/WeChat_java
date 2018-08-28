package com.tencent.mm.ui.conversation;

import com.tencent.mm.a.e;
import com.tencent.mm.c.a;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

class i$4 implements Runnable {
    final /* synthetic */ i uqR;
    final /* synthetic */ bsx uqS;

    i$4(i iVar, bsx bsx) {
        this.uqR = iVar;
        this.uqS = bsx;
    }

    public final void run() {
        if (this.uqS != null && this.uqS.knl.equalsIgnoreCase(i.eU(ad.getContext()))) {
            if (e.cn(this.uqS.sqp) && a.cE(this.uqS.sqp)) {
                ah.A(new 1(this));
            } else {
                ah.A(new 2(this));
            }
        }
    }
}
