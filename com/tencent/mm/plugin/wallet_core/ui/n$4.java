package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class n$4 implements OnClickListener {
    final /* synthetic */ n pxQ;

    n$4(n nVar) {
        this.pxQ = nVar;
    }

    public final void onClick(View view) {
        if (this.pxQ.pxH == 0) {
            n.a(this.pxQ);
        } else if (this.pxQ.pxH == 1) {
            n.b(this.pxQ);
        }
        if (this.pxQ.pxH == 1) {
            n.bQx();
            if (n.c(this.pxQ)) {
                n.d(this.pxQ);
            }
        }
    }
}
