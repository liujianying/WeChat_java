package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.h.c;

class l$2 implements c {
    final /* synthetic */ OnDismissListener qQd;
    final /* synthetic */ String qQe;
    final /* synthetic */ Context val$context;

    l$2(OnDismissListener onDismissListener, String str, Context context) {
        this.qQd = onDismissListener;
        this.qQe = str;
        this.val$context = context;
    }

    public final void ju(int i) {
        if (this.qQd != null) {
            this.qQd.onDismiss(null);
        }
        String replace = this.qQe.replace(" ", "").replace("#", "@");
        switch (i) {
            case 0:
                l.bn(this.val$context, replace);
                return;
            default:
                return;
        }
    }
}
