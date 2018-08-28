package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.tencentmap.mapsdk.a.mu.b;

class mu$1 extends Handler {
    final /* synthetic */ mu a;

    mu$1(mu muVar) {
        this.a = muVar;
    }

    public void handleMessage(Message message) {
        if (!mu.a(this.a)) {
            Object obj = message.obj;
            if (obj != null) {
                mu.a(this.a, (b) obj);
                super.handleMessage(message);
            }
        }
    }
}
