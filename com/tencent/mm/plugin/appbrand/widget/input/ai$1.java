package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ai$1 extends Handler {
    final /* synthetic */ ai gJL;

    ai$1(ai aiVar, Looper looper) {
        this.gJL = aiVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
            case 2:
                if (ai.a(this.gJL)) {
                    sendMessageDelayed(Message.obtain(ai.b(this.gJL), 2), 50);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
