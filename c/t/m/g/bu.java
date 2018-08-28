package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.bp.a;

final class bu implements Runnable {
    private /* synthetic */ bp a;

    bu(bp bpVar) {
        this.a = bpVar;
    }

    public final void run() {
        try {
            p.e();
            a a = bp.a(this.a, p.b());
            if (SystemClock.elapsedRealtime() - a.a > ((long) bp.c(a.b))) {
                this.a.c.removeCallbacks(this.a.g);
                this.a.c.post(this.a.g);
            }
        } catch (Throwable th) {
        }
    }
}
