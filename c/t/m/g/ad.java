package c.t.m.g;

import java.util.TimerTask;

final class ad extends TimerTask {
    private /* synthetic */ Runnable a;

    ad(Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        this.a.run();
    }
}
