package com.google.android.exoplayer2.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class r {
    final ExecutorService aBG;
    b<? extends c> aBH;
    IOException atg;

    public interface c {
        void kQ();

        boolean kR();

        void kS();
    }

    private static final class e extends Handler implements Runnable {
        private final d aBQ;

        public e(d dVar) {
            this.aBQ = dVar;
        }

        public final void run() {
            sendEmptyMessage(0);
        }

        public final void handleMessage(Message message) {
            this.aBQ.lb();
        }
    }

    public r(String str) {
        this.aBG = t.aA(str);
    }

    public final <T extends c> long a(T t, a<T> aVar, int i) {
        Looper myLooper = Looper.myLooper();
        a.ap(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b(this, myLooper, t, aVar, i, elapsedRealtime).start(0);
        return elapsedRealtime;
    }

    public final boolean iD() {
        return this.aBH != null;
    }

    public final void lY() {
        this.aBH.an(false);
    }

    public final boolean a(d dVar) {
        boolean z = false;
        if (this.aBH != null) {
            this.aBH.an(true);
            if (dVar != null) {
                this.aBG.execute(new e(dVar));
            }
        } else if (dVar != null) {
            dVar.lb();
            z = true;
        }
        this.aBG.shutdown();
        return z;
    }

    public final void kC() {
        if (this.atg != null) {
            throw this.atg;
        } else if (this.aBH != null) {
            b bVar = this.aBH;
            int i = this.aBH.aBK;
            if (bVar.aBM != null && bVar.aBN > i) {
                throw bVar.aBM;
            }
        }
    }
}
