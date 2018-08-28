package com.tencent.matrix.resource.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class e {
    final Handler bsK;
    private final long bsL;
    final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public interface a {

        public enum a {
            ;

            static {
                bsP = 1;
                bsQ = 2;
                bsR = new int[]{bsP, bsQ};
            }
        }

        int tB();
    }

    public e(long j, HandlerThread handlerThread) {
        this.bsK = new Handler(handlerThread.getLooper());
        this.bsL = j;
    }

    public final void a(final a aVar, final int i) {
        this.bsK.postDelayed(new Runnable() {
            public final void run() {
                if (aVar.tB() == a.bsQ) {
                    e.this.a(aVar, i + 1);
                }
            }
        }, this.bsL);
    }
}
