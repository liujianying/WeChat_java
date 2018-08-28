package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e$1 extends Handler {
    final /* synthetic */ e vcj;

    e$1(e eVar, Looper looper) {
        this.vcj = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.vcj.a((d) message.obj);
    }
}
