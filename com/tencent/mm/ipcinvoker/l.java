package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mm.ipcinvoker.a.b;
import java.util.concurrent.ExecutorService;

class l {
    private static volatile l dmL;
    private static b dmM = new a();
    ExecutorService dmN = dmM.Cx();
    private Handler mHandler;

    private static l Cv() {
        if (dmL == null) {
            synchronized (l.class) {
                if (dmL == null) {
                    dmL = new l();
                }
            }
        }
        return dmL;
    }

    static l Cw() {
        return new l();
    }

    private l() {
        HandlerThread handlerThread = new HandlerThread("ThreadPool#WorkerThread-" + hashCode());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new 1(this, handlerThread));
        this.mHandler = handler;
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "initialize IPCInvoker ThreadPool(hashCode : %s)", new Object[]{Integer.valueOf(hashCode())});
    }

    public static boolean post(Runnable runnable) {
        Cv().dmN.execute(runnable);
        return true;
    }

    public static boolean i(Runnable runnable) {
        return Cv().mHandler.postDelayed(runnable, 2000);
    }
}
