package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class MemoryLeakActivity$4 implements OnDismissListener {
    final /* synthetic */ MemoryLeakActivity euU;

    MemoryLeakActivity$4(MemoryLeakActivity memoryLeakActivity) {
        this.euU = memoryLeakActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.euU.finish();
    }
}
