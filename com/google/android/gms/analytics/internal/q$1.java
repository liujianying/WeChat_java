package com.google.android.gms.analytics.internal;

import java.lang.Thread.UncaughtExceptionHandler;

class q$1 implements UncaughtExceptionHandler {
    final /* synthetic */ q aGh;

    q$1(q qVar) {
        this.aGh = qVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        f fVar = this.aGh.aFW;
        if (fVar != null) {
            fVar.g("Job execution failed", th);
        }
    }
}
