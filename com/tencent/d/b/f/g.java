package com.tencent.d.b.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.d.a.c.c;

public class g {
    private static volatile g vmA = null;
    private Handler vmB = null;
    private Handler vmC = null;

    private g() {
        HandlerThread handlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.vmB = new Handler(handlerThread.getLooper());
        } else {
            c.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
            this.vmB = new Handler(Looper.getMainLooper());
        }
        this.vmC = new Handler(Looper.getMainLooper());
    }

    public static g cGb() {
        if (vmA != null) {
            return vmA;
        }
        g gVar;
        synchronized (g.class) {
            if (vmA == null) {
                vmA = new g();
            }
            gVar = vmA;
        }
        return gVar;
    }

    public final void C(Runnable runnable) {
        this.vmB.post(runnable);
    }

    public final void l(Runnable runnable, long j) {
        this.vmB.postDelayed(runnable, j);
    }

    public final void A(Runnable runnable) {
        this.vmC.post(runnable);
    }
}
