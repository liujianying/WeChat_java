package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Vending$f<_Index> {
    AtomicBoolean fjt = new AtomicBoolean(false);
    Handler mVendingHandler;
    HashMap<_Index, b> uQg = new HashMap();
    a<_Index> uQh = null;
    byte[] uQi = new byte[0];

    protected interface a<_Index> {
        void cancel();

        void cs(_Index _index);
    }

    public enum b {
        NIL,
        PENDING,
        FILLED
    }

    protected Vending$f(Looper looper, a<_Index> aVar) {
        this.uQh = aVar;
        this.mVendingHandler = new 1(this, looper);
    }

    protected final void cBA() {
        this.mVendingHandler.removeCallbacksAndMessages(null);
        com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
        synchronized (this.uQi) {
            this.uQg.clear();
        }
        this.uQh.cancel();
    }
}
