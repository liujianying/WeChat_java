package com.tencent.mm.plugin.scanner.a;

import android.os.Bundle;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b mFK;

    b$1(b bVar) {
        this.mFK = bVar;
    }

    public final void o(int i, Bundle bundle) {
        x.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[]{Integer.valueOf(i)});
        kh khVar = new kh();
        khVar.bUG.bUE = i;
        khVar.bUG.activity = this.mFK.mActivity;
        khVar.bUG.bHL = this.mFK.mFE;
        khVar.bUG.bUH = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(khVar);
    }
}
