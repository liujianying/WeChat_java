package com.tencent.mm.ax;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$1 implements OnClickListener {
    final /* synthetic */ Runnable ele;

    e$1(Runnable runnable) {
        this.ele = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.ele != null) {
            this.ele.run();
        }
    }
}
