package c.t.m.g;

import android.os.Looper;
import c.t.m.g.dg.b;

class dg$2 implements Runnable {
    private /* synthetic */ dg a;

    dg$2(dg dgVar) {
        this.a = dgVar;
    }

    public final void run() {
        try {
            Looper looper = dg.a(this.a) == null ? null : dg.a(this.a).getLooper();
            if (looper != null && looper.getThread().isAlive()) {
                dg.a(this.a, b.b);
                dg.a(this.a, looper);
            }
        } catch (Throwable th) {
        }
    }
}
