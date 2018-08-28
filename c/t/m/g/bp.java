package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public final class bp implements bw, Runnable {
    private static bp b = new bp();
    public bd a;
    private Handler c;
    private Map<String, bl> d = new ConcurrentHashMap();
    private Runnable e = new bs(this);
    private Runnable f = new bu(this);
    private Runnable g = new bv(this);
    private Map<String, a> h = new HashMap();

    private bp() {
    }

    private static int c(int i) {
        String str = i == 0 ? "http_platform_update_interval_succ" : (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        int i2 = i == 0 ? 1800000 : (i == -4 || i == -3) ? 60000 : 300000;
        return w.a(str, 60000, 3600000, i2);
    }

    public static bp c() {
        return b;
    }

    public final void a() {
        ((bl) this.d.get("accessscheduler")).a();
    }

    public final void a(int i) {
        if (i == 1 || i == 2) {
            this.c.removeCallbacks(this.f);
            this.c.post(this.f);
        } else if (i == 3 || i == 4) {
            ac.a().a(this.e, false, (long) ((i == 3 ? c(-4) : c(0)) + ((new Random().nextInt(w.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60) * BaseReportManager.MAX_READ_COUNT)));
        }
    }

    public final void a(bd bdVar) {
        this.a = bdVar;
        bt btVar = new bt();
        this.d.put(btVar.c(), btVar);
        bn bnVar = new bn();
        this.d.put(bnVar.c(), bnVar);
        bq bqVar = new bq();
        this.d.put(bqVar.c(), bqVar);
    }

    public final void b() {
        ((bl) this.d.get("settings")).b();
    }

    public final void d() {
        HandlerThread handlerThread = new HandlerThread("HttpPlatformConnection");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.c.post(this);
        this.a.a_();
    }

    public final void run() {
        if (w.a("http_platform_start_update_on", 0, 1, 0) == 1) {
            this.c.post(this.g);
        }
    }

    static /* synthetic */ a a(bp bpVar, String str) {
        a aVar = (a) bpVar.h.get(str);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a((byte) 0);
        bpVar.h.put(str, aVar);
        return aVar;
    }
}
