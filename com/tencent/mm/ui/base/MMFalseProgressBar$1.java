package com.tencent.mm.ui.base;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class MMFalseProgressBar$1 extends ag {
    final /* synthetic */ MMFalseProgressBar tug;

    MMFalseProgressBar$1(MMFalseProgressBar mMFalseProgressBar, Looper looper) {
        this.tug = mMFalseProgressBar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case BaseReportManager.MAX_READ_COUNT /*1000*/:
                MMFalseProgressBar.a(this.tug);
                return;
            case 1001:
                MMFalseProgressBar.b(this.tug);
                return;
            case 1002:
                MMFalseProgressBar.c(this.tug);
                return;
            case 1003:
                MMFalseProgressBar.d(this.tug);
                return;
            default:
                return;
        }
    }
}
