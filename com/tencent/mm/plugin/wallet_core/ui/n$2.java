package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class n$2 implements OnClickListener {
    final /* synthetic */ n pxQ;

    n$2(n nVar) {
        this.pxQ = nVar;
    }

    public final void onClick(View view) {
        if (!this.pxQ.kMk.isShown()) {
            this.pxQ.kMk.setVisibility(0);
        }
    }
}
