package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class k$4 implements OnClickListener {
    final /* synthetic */ Dialog nmd;

    k$4(Dialog dialog) {
        this.nmd = dialog;
    }

    public final void onClick(View view) {
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
