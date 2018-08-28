package com.tencent.tencentmap.mapsdk.a;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class el$a extends el {
    private ScheduledExecutorService a;
    private boolean b;

    public el$a() {
        this.a = null;
        this.b = false;
        this.a = Executors.newSingleThreadScheduledExecutor();
        SparseArray sparseArray = new SparseArray();
    }

    public final synchronized void a(Runnable runnable) {
        if (runnable == null) {
            fx.b("AsyncTaskHandlerAbs", "task runner should not be null");
        } else {
            this.a.execute(runnable);
        }
    }
}
