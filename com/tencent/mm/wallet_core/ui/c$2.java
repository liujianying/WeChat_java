package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnClickListener {
    final /* synthetic */ c uYM;

    c$2(c cVar) {
        this.uYM = cVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.OfflinePopupWindow", "on click know");
        this.uYM.uYK.setVisibility(8);
        ci ciVar = new ci();
        ciVar.bJP.bJQ = 1;
        a.sFg.m(ciVar);
    }
}
