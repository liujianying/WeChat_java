package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends h {
    final String TAG;
    final g fdO;
    final d fjo;
    final a fjp;
    final e fjq;
    final c fjr;
    final b fjs;
    public final AtomicBoolean fjt;
    private final AtomicBoolean fju;
    private final AtomicReference<com.tencent.mm.sdk.d.c> fjv;
    private final AtomicReference<com.tencent.mm.sdk.d.c> fjw;

    /* renamed from: com.tencent.mm.plugin.appbrand.b.c$7 */
    static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] fjn = new int[a.values().length];

        static {
            try {
                fjn[a.fje.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fjn[a.fjg.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fjn[a.fjh.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fjn[a.fjf.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    abstract void acu();

    public abstract void b(a aVar);

    static /* synthetic */ void a(c cVar, g gVar) {
        cVar.fju.set(false);
        cVar.fjv.set(gVar);
        cVar.fjw.set(null);
        super.b(gVar);
    }

    c(g gVar) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + gVar.mAppId + "]", gVar.aaq() ? new ah("AppRunningStateMachineForGameRuntime").lnJ.getLooper() : Looper.getMainLooper());
        this.fjt = new AtomicBoolean(false);
        this.fju = new AtomicBoolean(false);
        this.fjv = new AtomicReference(null);
        this.fjw = new AtomicReference(null);
        this.TAG = this.mName;
        this.fdO = gVar;
        this.fjr = new c(this, this);
        this.fjs = new b(this, this);
        this.fjp = new a(this, this, gVar);
        this.fjo = new d(this, this);
        this.fjq = new e(this, this);
        1 1 = new 1(this);
        if (Looper.myLooper() == this.sJQ.getLooper()) {
            1.run();
            return;
        }
        this.fju.set(true);
        this.sJQ.post(1);
    }

    public final void start() {
        if (!this.fjt.get()) {
            if (Looper.myLooper() == this.sJQ.getLooper()) {
                super.start();
            } else {
                this.sJQ.post(new 2(this));
            }
        }
    }

    final void a(g gVar) {
        this.fjv.set(null);
        this.fjw.set(gVar);
        Message cjm = cjm();
        if (cjm == null || cjm.what != -2) {
            b(a((a) gVar));
        }
    }

    public final a acv() {
        com.tencent.mm.sdk.d.d.c cVar = this.sJQ;
        if (cVar == null) {
            return a.fjh;
        }
        if (!this.fju.get() || Thread.currentThread().getId() == cVar.getLooper().getThread().getId()) {
            return acw();
        }
        if (!ah.isMainThread()) {
            return (a) new 3(this).a(new ag(cVar.getLooper()));
        }
        a aVar = (com.tencent.mm.sdk.d.c) this.fjw.get();
        x.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", new Object[]{Long.valueOf(cVar.getLooper().getThread().getId()), aVar, Boolean.valueOf(this.fjt.get())});
        if (aVar != null) {
            return a(aVar);
        }
        return r2 ? a.fjh : a.fje;
    }

    private a acw() {
        if (this.fjt.get()) {
            return a.fjh;
        }
        a aVar = (com.tencent.mm.sdk.d.c) this.fjv.get();
        if (aVar != null) {
            return a(aVar);
        }
        aVar = (com.tencent.mm.sdk.d.c) this.fjw.get();
        if (aVar != null) {
            return a(aVar);
        }
        if (Thread.currentThread().getId() != this.sJQ.getLooper().getThread().getId()) {
            aVar = (a) new bd<a>() {
                protected final /* synthetic */ Object run() {
                    return super.cjn();
                }
            }.a(new ag(this.sJQ.getLooper()));
        } else {
            aVar = super.cjn();
        }
        return a(aVar);
    }

    private a a(a aVar) {
        if (aVar == this.fjp || aVar == this.fjr || aVar == this.fjs) {
            return a.fjf;
        }
        if (aVar == this.fjq) {
            return a.fjg;
        }
        if (aVar == this.fjo) {
            return a.fje;
        }
        return a.fje;
    }

    public final void jG(int i) {
        this.fju.set(true);
        if (cjm() == null) {
            super.Dd(i);
        } else {
            super.De(i);
        }
    }

    protected final boolean h(Message message) {
        return message.what != 1000;
    }

    protected final void i(Message message) {
        super.i(message);
        this.fju.set(false);
    }

    protected final void abD() {
        super.abD();
        if (this.sJQ.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.sJQ.post(new 6(this));
        }
    }
}
