package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class o$2 implements OnClickListener {
    final /* synthetic */ o pxX;

    o$2(o oVar) {
        this.pxX = oVar;
    }

    public final void onClick(View view) {
        if (!this.pxX.kMk.isShown()) {
            this.pxX.kMk.setVisibility(0);
        }
    }
}
