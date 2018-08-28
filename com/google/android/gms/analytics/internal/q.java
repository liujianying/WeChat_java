package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.v;
import com.google.android.gms.c.w;
import com.google.android.gms.common.internal.f;

public class q {
    private static q aFT;
    public final v aFC = w.qf();
    final Context aFU;
    final ac aFV = r.b(this);
    final f aFW;
    private final ah aFX;
    private final m aFY;
    final ag aFZ;
    private final l aGa;
    final i aGb;
    private final a aGc;
    private final y aGd;
    public final a aGe;
    public final v aGf;
    public final af aGg;
    final Context mContext;

    private q(r rVar) {
        Context context = rVar.aGi;
        com.google.android.gms.common.internal.w.j(context, "Application context can't be null");
        com.google.android.gms.common.internal.w.e(context instanceof Application, "getApplicationContext didn't return the application");
        Context context2 = rVar.aGj;
        com.google.android.gms.common.internal.w.ah(context2);
        this.mContext = context;
        this.aFU = context2;
        f fVar = new f(this);
        fVar.nq();
        this.aFW = fVar;
        if (f.aNr) {
            nr().aQ("Google Analytics " + p.VERSION + " is starting up.");
        } else {
            nr().aQ("Google Analytics " + p.VERSION + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        }
        i f = r.f(this);
        f.nq();
        this.aGb = f;
        l lVar = new l(this);
        lVar.nq();
        this.aGa = lVar;
        m mVar = new m(this, rVar);
        y a = r.a(this);
        a aVar = new a(this);
        v vVar = new v(this);
        af afVar = new af(this);
        ah au = ah.au(context);
        au.aYp = new 1(this);
        this.aFX = au;
        a aVar2 = new a(this);
        a.nq();
        this.aGd = a;
        aVar.nq();
        this.aGe = aVar;
        vVar.nq();
        this.aGf = vVar;
        afVar.nq();
        this.aGg = afVar;
        ag e = r.e(this);
        e.nq();
        this.aFZ = e;
        mVar.nq();
        this.aFY = mVar;
        if (f.aNr) {
            nr().e("Device AnalyticsService version", p.VERSION);
        }
        l nv = aVar2.aHe.nv();
        if (nv.nd()) {
            e.mL().setLogLevel(nv.getLogLevel());
        }
        if (nv.ng()) {
            aVar2.aEK = nv.nh();
        }
        if (nv.nd()) {
            b mL = e.mL();
            if (mL != null) {
                mL.setLogLevel(nv.getLogLevel());
            }
        }
        aVar2.aEH = true;
        this.aGc = aVar2;
        mVar.aFJ.start();
    }

    public static void a(o oVar) {
        com.google.android.gms.common.internal.w.j(oVar, "Analytics service not created/initialized");
        com.google.android.gms.common.internal.w.e(oVar.isInitialized(), "Analytics service not initialized");
    }

    public static q ac(Context context) {
        com.google.android.gms.common.internal.w.ah(context);
        if (aFT == null) {
            synchronized (q.class) {
                if (aFT == null) {
                    v qf = w.qf();
                    long elapsedRealtime = qf.elapsedRealtime();
                    q qVar = new q(new r(context.getApplicationContext()));
                    aFT = qVar;
                    a.mD();
                    elapsedRealtime = qf.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) aj.aIh.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        qVar.nr().c("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return aFT;
    }

    public static void nx() {
        ah.nx();
    }

    public final f nr() {
        a(this.aFW);
        return this.aFW;
    }

    public final ah ns() {
        com.google.android.gms.common.internal.w.ah(this.aFX);
        return this.aFX;
    }

    public final m nt() {
        a(this.aFY);
        return this.aFY;
    }

    public final a nu() {
        com.google.android.gms.common.internal.w.ah(this.aGc);
        a aVar = this.aGc;
        boolean z = aVar.aEH && !aVar.aEI;
        com.google.android.gms.common.internal.w.e(z, "Analytics instance not initialized");
        return this.aGc;
    }

    public final l nv() {
        a(this.aGa);
        return this.aGa;
    }

    public final y nw() {
        a(this.aGd);
        return this.aGd;
    }
}
