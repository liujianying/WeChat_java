package com.tencent.mm.ax;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class e$2 implements OnCancelListener {
    final /* synthetic */ Runnable ele;

    e$2(Runnable runnable) {
        this.ele = runnable;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.ele != null) {
            this.ele.run();
        }
    }
}
