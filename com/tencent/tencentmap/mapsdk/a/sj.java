package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.a.sf.1;

final class sj extends Handler {
    private /* synthetic */ 1 a;

    sj(1 1) {
        this.a = 1;
    }

    public final void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1:
                    1.b(this.a).c(1.a(this.a));
                    return;
                default:
                    return;
            }
        }
    }
}
