package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.base.Vending.f;
import com.tencent.mm.vending.base.Vending.f.b;

class Vending$f$1 extends Handler {
    final /* synthetic */ f uQj;

    Vending$f$1(f fVar, Looper looper) {
        this.uQj = fVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.uQj.fjt.get()) {
            this.uQj.uQh.cancel();
            return;
        }
        Object obj = message.obj;
        this.uQj.uQh.cs(obj);
        synchronized (this.uQj.uQi) {
            this.uQj.uQg.put(obj, b.uQm);
        }
    }
}
