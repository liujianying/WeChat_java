package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MemoryLeakActivity$3 implements OnClickListener {
    final /* synthetic */ MemoryLeakActivity euU;

    MemoryLeakActivity$3(MemoryLeakActivity memoryLeakActivity) {
        this.euU = memoryLeakActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MemoryLeakActivity.b(this.euU) != null && MemoryLeakActivity.b(this.euU).isShowing()) {
            MemoryLeakActivity.b(this.euU).dismiss();
        }
        this.euU.finish();
    }
}
