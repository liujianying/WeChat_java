package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h uRC = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h uRD = new h(b.cBP().uRM.getLooper(), "Vending.LOGIC");
    public static final h uRE = new h(a.cBO().uRK.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract void g(Runnable runnable);

    public abstract void g(Runnable runnable, long j);

    public abstract String getType();

    static {
        g.cBN();
    }

    public static synchronized d cBM() {
        d cBM;
        synchronized (d.class) {
            cBM = g.cBM();
        }
        return cBM;
    }
}
