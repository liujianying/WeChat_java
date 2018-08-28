package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Looper;
import android.os.Process;

class q$b implements Runnable {
    private final Runnable epp;

    /* synthetic */ q$b(Runnable runnable, byte b) {
        this(runnable);
    }

    private q$b(Runnable runnable) {
        this.epp = runnable;
    }

    public final void run() {
        if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
            Process.setThreadPriority(10);
        }
        if (this.epp != null) {
            this.epp.run();
        }
    }
}
