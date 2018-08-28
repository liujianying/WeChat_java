package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.k;

class l$5 implements l$a$a {
    final /* synthetic */ OnDismissListener qQd;
    final /* synthetic */ k qQg;

    l$5(k kVar, OnDismissListener onDismissListener) {
        this.qQg = kVar;
        this.qQd = onDismissListener;
    }

    public final void ga(boolean z) {
        if (z) {
            this.qQg.dismiss();
            if (this.qQd != null) {
                this.qQd.onDismiss(null);
            }
        }
    }
}
