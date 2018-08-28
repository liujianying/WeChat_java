package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c$2 extends Handler {
    final /* synthetic */ c uQx;

    c$2(c cVar, Looper looper) {
        this.uQx = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        synchronized (this.uQx.uQv) {
            if (this.uQx.uQw != null) {
                this.uQx.uQw.synchronizing(message.what, message.obj);
            }
            this.uQx.uQv.notify();
        }
    }
}
