package com.tencent.mm.performance.wxperformancetool;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bv.b;

class MemoryLeakActivity$2 implements OnClickListener {
    final /* synthetic */ MemoryLeakActivity euU;
    final /* synthetic */ String euV;

    MemoryLeakActivity$2(MemoryLeakActivity memoryLeakActivity, String str) {
        this.euU = memoryLeakActivity;
        this.euV = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.ZO(this.euV);
        if (MemoryLeakActivity.b(this.euU) != null && MemoryLeakActivity.b(this.euU).isShowing()) {
            MemoryLeakActivity.b(this.euU).dismiss();
        }
        this.euU.finish();
    }
}
