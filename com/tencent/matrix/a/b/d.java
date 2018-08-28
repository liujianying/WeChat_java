package com.tencent.matrix.a.b;

import android.os.Handler;

public final class d {
    public Handler bqd;
    public boolean started = false;

    public final void f(Runnable runnable) {
        this.bqd.post(runnable);
    }
}
