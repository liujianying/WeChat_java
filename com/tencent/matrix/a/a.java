package com.tencent.matrix.a;

import android.app.Application;
import android.os.Handler;
import android.os.PowerManager;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.a.b.d;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.f;
import com.tencent.matrix.b.b;

public final class a extends b {
    public final com.tencent.matrix.a.a.a boV;
    private c boW;

    public a() {
        this.boV = com.tencent.matrix.a.a.a.boX;
    }

    public a(com.tencent.matrix.a.a.a aVar) {
        this.boV = aVar;
    }

    public final void a(Application application, com.tencent.matrix.b.c cVar) {
        super.a(application, cVar);
        com.tencent.matrix.a.c.a.ay(application);
        com.tencent.matrix.a.c.a.bZ(com.tencent.matrix.d.c.aC(application));
        this.boW = new c(this);
    }

    public final void start() {
        super.start();
        Object obj = this.boW;
        d dVar = obj.bpJ;
        if (!dVar.started) {
            dVar.bqd = new Handler(com.tencent.matrix.d.a.tJ().getLooper());
            dVar.started = true;
        }
        com.tencent.matrix.a.a.a aVar = obj.boV;
        if (aVar == null) {
            throw new RuntimeException("batteryConfig is null");
        }
        if (aVar.el(1)) {
            obj.bpM = new f(obj, aVar, new com.tencent.matrix.a.b.f.a() {
                public final void b(Runnable runnable, long j) {
                    c.this.bpJ.bqd.postDelayed(runnable, j);
                }

                public final boolean isScreenOn() {
                    return ((PowerManager) c.this.mContext.getSystemService("power")).isScreenOn();
                }
            });
            e.a(obj);
        }
        if (aVar.el(4)) {
            obj.bpN = new com.tencent.matrix.a.b.a(obj, obj.boV);
            obj.bpJ.f(new Runnable() {
                public final void run() {
                    c.this.bpN.ti();
                }
            });
            com.tencent.matrix.a.b.b.a(obj);
        }
        synchronized (obj) {
            obj.bpL = true;
        }
    }

    public final void stop() {
        super.stop();
        c cVar = this.boW;
        synchronized (cVar) {
            cVar.bpL = false;
        }
        e.b(cVar);
        com.tencent.matrix.a.b.b.b(cVar);
        d dVar = cVar.bpJ;
        if (dVar.started) {
            dVar.bqd.removeCallbacksAndMessages(null);
            dVar.started = false;
        }
    }

    public final String getTag() {
        return "battery";
    }
}
