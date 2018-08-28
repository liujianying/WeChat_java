package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import c.t.m.g.as.a;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class al {
    private static int f = 20;
    protected AtomicInteger a = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    public int c;
    private final String d = a();
    private long e;
    private Handler g;
    private as h;
    private AtomicInteger i = new AtomicInteger(0);
    private List<String> j = new ArrayList();
    private volatile boolean k = false;
    private volatile boolean l = false;
    private int m = 0;
    private long n = 0;
    private AtomicInteger o = new AtomicInteger(0);
    private volatile boolean p = false;
    private a q = new ao(this);
    private final Runnable r = new aq(this);
    private final Runnable s = new ar(this);

    public al() {
        at.a(m.a());
        HandlerThread handlerThread = new HandlerThread(this.d, 10);
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
        this.h = new am();
        a(true);
        b(true, false);
        this.c = b();
    }

    private void a(boolean z) {
        if (z) {
            this.g.postDelayed(new ap(this), 5000);
        } else if (this.e != 0 && SystemClock.elapsedRealtime() - this.e > 1800000) {
            f();
        }
    }

    private synchronized void a(boolean z, boolean z2) {
        a(false);
        if (z && z2) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (!this.k) {
            if (!z) {
                this.i.set(0);
            }
            if (this.n == 0 || SystemClock.elapsedRealtime() - this.n >= ((long) ((this.m * 60) * TbsLog.TBSLOG_CODE_SDK_BASE))) {
                this.k = true;
                try {
                    new d(this, z, z2).a(true);
                } catch (Throwable th) {
                    this.k = false;
                }
            }
        } else if (z) {
            this.l = true;
        }
        return;
    }

    private void b(boolean z, boolean z2) {
        if (z2) {
            if (this.o.get() > 3) {
                this.o.set(0);
            } else {
                ac.a().a(this.r, false, (long) (w.a("report_real_timer_interval", 1, 60, 5) * TbsLog.TBSLOG_CODE_SDK_BASE));
            }
        } else if (z) {
            ac.a().a(this.s, false, 10000);
        } else if (!this.p) {
            ac.a().a(this.s, false, (long) w.a("report_timer_interval", 30000, 600000, 300000));
        }
    }

    private void f() {
        this.e = SystemClock.elapsedRealtime();
        int c = cd.c("report_missing_event");
        int c2 = cd.c("report_using_traffic");
        int a = w.a("report_using_traffic_limit", 1, 10240, 32);
        if (c != 0 || c2 >= (a << 10)) {
            long b = cd.b("report_traffic_last_time");
            if (b == 0) {
                cd.a("report_traffic_last_time", System.currentTimeMillis());
                return;
            }
            b = System.currentTimeMillis() - b;
            Map hashMap = new HashMap();
            hashMap.put("B110", String.valueOf(c2));
            hashMap.put("B112", b < 0 ? "0" : String.valueOf(b));
            if (c == 0) {
                ce.b("HLReportEvent", m.b(), 0, "", hashMap, null, false);
            } else {
                hashMap.put("B111", String.valueOf(c));
                ce.b("HLReportEvent", m.b(), -500, "", hashMap, null, false);
                cd.a("report_missing_event", 0);
            }
            cd.a("report_using_traffic", 0);
        }
    }

    static /* synthetic */ int k(al alVar) {
        int i = alVar.m - 10;
        alVar.m = i;
        return i;
    }

    static /* synthetic */ int n(al alVar) {
        int i = alVar.m << 1;
        alVar.m = i;
        return i;
    }

    public abstract String a();

    public abstract int b();

    public abstract String c();
}
