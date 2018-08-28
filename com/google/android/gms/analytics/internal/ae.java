package com.google.android.gms.analytics.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.w;

abstract class ae {
    private static volatile Handler aHj;
    final q aFn;
    final Runnable aHk = new 1(this);
    volatile long aHl;
    private boolean aHm;

    ae(q qVar) {
        w.ah(qVar);
        this.aFn = qVar;
    }

    public final void ac(long j) {
        cancel();
        if (j >= 0) {
            this.aHl = this.aFn.aFC.currentTimeMillis();
            if (!getHandler().postDelayed(this.aHk, j)) {
                this.aFn.nr().g("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void cancel() {
        this.aHl = 0;
        getHandler().removeCallbacks(this.aHk);
    }

    final Handler getHandler() {
        if (aHj != null) {
            return aHj;
        }
        Handler handler;
        synchronized (ae.class) {
            if (aHj == null) {
                aHj = new Handler(this.aFn.mContext.getMainLooper());
            }
            handler = aHj;
        }
        return handler;
    }

    public final boolean of() {
        return this.aHl != 0;
    }

    public abstract void run();
}
