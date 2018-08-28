package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

class l$6 implements OnCancelListener {
    final /* synthetic */ OnDismissListener qQd;

    l$6(OnDismissListener onDismissListener) {
        this.qQd = onDismissListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.qQd != null) {
            this.qQd.onDismiss(null);
        }
    }
}
