package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

class cm$2 extends TimerTask {
    private /* synthetic */ Timer a;

    cm$2(Timer timer) {
        this.a = timer;
    }

    public final void run() {
        try {
            this.a.cancel();
        } catch (Throwable th) {
            cj.a("CC_", "timer cancel error.", th);
        }
    }
}
