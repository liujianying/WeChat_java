package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.base.Vending.i;

class Vending$5 extends Handler {
    final /* synthetic */ Vending uQd;

    Vending$5(Vending vending, Looper looper) {
        this.uQd = vending;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                i iVar = (i) message.obj;
                Vending.access$900(this.uQd, iVar.uQp, iVar.uQq);
                return;
            default:
                return;
        }
    }
}
