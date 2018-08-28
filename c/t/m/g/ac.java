package c.t.m.g;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public final class ac {
    private static ac a = new ac();
    private Timer b = new Timer("ConnectionTimer", true);
    private Map<Runnable, TimerTask> c = new ConcurrentHashMap();

    private ac() {
    }

    public static ac a() {
        return a;
    }

    public final void a(Runnable runnable, boolean z, long j) {
        synchronized (runnable) {
            a(runnable);
            ad adVar = new ad(runnable);
            if (z) {
                this.b.schedule(adVar, j, j);
            } else {
                this.b.schedule(adVar, j);
            }
            this.c.put(runnable, adVar);
        }
    }

    public final boolean a(Runnable runnable) {
        synchronized (runnable) {
            TimerTask timerTask = (TimerTask) this.c.get(runnable);
            if (timerTask != null) {
                this.c.remove(runnable);
                boolean cancel = timerTask.cancel();
                return cancel;
            }
            return true;
        }
    }
}
