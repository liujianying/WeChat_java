package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class c$4 implements OnClickListener {
    final /* synthetic */ c uYM;

    c$4(c cVar) {
        this.uYM = cVar;
    }

    public final void onClick(View view) {
        if (this.uYM.eZB != null && this.uYM.eZB.isShowing()) {
            this.uYM.eZB.dismiss();
        }
    }
}
