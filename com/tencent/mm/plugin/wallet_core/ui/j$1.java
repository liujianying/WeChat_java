package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class j$1 implements OnClickListener {
    final /* synthetic */ j pvv;

    j$1(j jVar) {
        this.pvv = jVar;
    }

    public final void onClick(View view) {
        j.a(this.pvv);
        this.pvv.dismiss();
    }
}
