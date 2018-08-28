package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.b.b;
import com.tencent.matrix.trace.d.c;
import com.tencent.matrix.trace.d.d;

public class a extends b {
    private final com.tencent.matrix.trace.a.a bsS;
    private c bsT;
    private com.tencent.matrix.trace.d.b bsU;
    public d bsV;

    public a(com.tencent.matrix.trace.a.a aVar) {
        this.bsS = aVar;
    }

    public final void a(Application application, com.tencent.matrix.b.c cVar) {
        super.a(application, cVar);
        com.tencent.matrix.d.b.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", this.bsS.toString());
        if (VERSION.SDK_INT < 16) {
            com.tencent.matrix.d.b.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
            this.brg = false;
            return;
        }
        com.tencent.matrix.trace.core.a.b(application);
        this.bsV = new d(this);
        if (this.bsS.bsX) {
            this.bsT = new c(this, this.bsS);
        }
        if (this.bsS.bsY) {
            this.bsU = new com.tencent.matrix.trace.d.b(this, this.bsS);
        }
    }

    public final void start() {
        super.start();
        if (this.brg) {
            if (this.bsT != null) {
                this.bsT.onCreate();
            }
            if (this.bsU != null) {
                this.bsU.onCreate();
            }
            if (this.bsV != null) {
                this.bsV.onCreate();
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    com.tencent.matrix.trace.core.a.a tF = com.tencent.matrix.trace.core.b.tF();
                    if (com.tencent.matrix.d.c.aj(Thread.currentThread().getId())) {
                        com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onCreate] FrameBeat real onCreate!", new Object[0]);
                        if (tF.btA) {
                            com.tencent.matrix.d.b.w("Matrix.FrameBeat", "[onCreate] FrameBeat is created!", new Object[0]);
                            return;
                        }
                        tF.btA = true;
                        tF.btB = System.nanoTime();
                        com.tencent.matrix.trace.core.a.tE().a(tF);
                        tF.btz = Choreographer.getInstance();
                        return;
                    }
                    com.tencent.matrix.d.b.e("Matrix.FrameBeat", "[onCreate] FrameBeat must create on main thread", new Object[0]);
                }
            });
        }
    }

    public final void stop() {
        super.stop();
        if (this.brg) {
            com.tencent.matrix.trace.core.a.a tF = com.tencent.matrix.trace.core.b.tF();
            if (tF.btA) {
                tF.btA = false;
                tF.btz.removeFrameCallback(tF);
                tF.btz = null;
                if (tF.bty != null) {
                    tF.bty.clear();
                }
                com.tencent.matrix.trace.core.a.tE().b(tF);
            } else {
                com.tencent.matrix.d.b.w("Matrix.FrameBeat", "[onDestroy] FrameBeat is not created!", new Object[0]);
            }
            if (this.bsT != null) {
                this.bsT.onDestroy();
            }
            if (this.bsU != null) {
                this.bsU.onDestroy();
            }
            if (this.bsV != null) {
                this.bsV.onDestroy();
            }
        }
    }

    public final String getTag() {
        return "Trace";
    }
}
