package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c$1 extends Handler {
    final /* synthetic */ c uQx;

    c$1(c cVar, Looper looper) {
        this.uQx = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.uQx.l(message.what, message.obj);
    }
}
