package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;

class sh$1 extends Handler {
    private /* synthetic */ sh a;

    sh$1(sh shVar) {
        this.a = shVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 11:
                for (Runnable run : sh.a(this.a)) {
                    run.run();
                }
                sh.a(this.a).clear();
                if (sh.b(this.a) != null) {
                    sh.b(this.a).a();
                    return;
                }
                return;
            case 16:
                sh.c(this.a).o();
                return;
            default:
                return;
        }
    }
}
