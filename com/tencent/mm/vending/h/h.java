package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class h extends d {
    Looper mLooper;
    public String mType;
    public a uRJ;

    private h(Looper looper, a aVar, String str) {
        this.mLooper = looper;
        this.uRJ = aVar;
        this.mType = str;
    }

    public h(Handler handler, String str) {
        this(new b(handler), str);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
    }

    public final String getType() {
        return this.mType;
    }

    public final void cancel() {
        this.uRJ.cA();
    }

    public final void g(Runnable runnable) {
        this.uRJ.j(runnable);
    }

    public final void g(Runnable runnable, long j) {
        if (j >= 0) {
            this.uRJ.k(runnable, j);
        } else {
            this.uRJ.j(runnable);
        }
    }
}
