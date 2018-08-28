package com.tencent.matrix.trace.c;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private final long btC;
    private volatile boolean btD = false;
    private final Handler mHandler;

    public interface a {
        void tG();
    }

    static class b implements Runnable {
        private final long btC;
        private final a btE;
        private final boolean btF;
        private final Handler handler;

        b(Handler handler, long j, a aVar, boolean z) {
            this.handler = handler;
            this.btC = j;
            this.btE = aVar;
            this.btF = z;
        }

        public final void run() {
            this.btE.tG();
            if (this.btF) {
                this.handler.postDelayed(this, this.btC);
            }
        }
    }

    public a(HandlerThread handlerThread, long j) {
        this.btC = j;
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public final void a(a aVar, boolean z) {
        if (this.mHandler != null) {
            this.btD = true;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.postDelayed(new b(this.mHandler, this.btC, aVar, z), this.btC);
        }
    }

    public final void cancel() {
        if (this.mHandler != null) {
            this.btD = false;
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
