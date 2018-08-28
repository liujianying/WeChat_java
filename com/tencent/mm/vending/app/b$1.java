package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class b$1 extends Handler {
    final /* synthetic */ b uPW;

    b$1(b bVar, Looper looper) {
        this.uPW = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        a aVar = (a) message.obj;
        switch (message.what) {
            case 1:
                aVar.onCreate();
                synchronized (aVar.uPI) {
                    aVar.uPL = true;
                    aVar.uPI.notify();
                }
                return;
            case 4:
                aVar.onDestroy();
                return;
            default:
                return;
        }
    }
}
