package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.ui.d.l.7;

class l$7$2 implements OnCancelListener {
    final /* synthetic */ 7 qQi;

    l$7$2(7 7) {
        this.qQi = 7;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.qQi.qQd != null) {
            this.qQi.qQd.onDismiss(null);
        }
    }
}
