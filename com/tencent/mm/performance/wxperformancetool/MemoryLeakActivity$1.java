package com.tencent.mm.performance.wxperformancetool;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

class MemoryLeakActivity$1 extends ag {
    final /* synthetic */ MemoryLeakActivity euU;

    MemoryLeakActivity$1(MemoryLeakActivity memoryLeakActivity) {
        this.euU = memoryLeakActivity;
    }

    public final void handleMessage(Message message) {
        if (((WeakReference) a.euW.get(MemoryLeakActivity.a(this.euU))).get() == null) {
            this.euU.finish();
        } else {
            MemoryLeakActivity.b(this.euU).show();
        }
    }
}
