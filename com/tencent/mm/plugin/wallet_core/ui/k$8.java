package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class k$8 implements OnClickListener {
    final /* synthetic */ Dialog nmd;

    public k$8(Dialog dialog) {
        this.nmd = dialog;
    }

    public final void onClick(View view) {
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
