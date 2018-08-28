package com.tencent.c.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.c.e.a.a.d;
import com.tencent.c.e.a.a.f;
import com.tencent.c.e.a.a.g;
import com.tencent.c.e.a.a.h;
import com.tencent.c.e.a.a.k;
import com.tencent.c.f.j;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static final j<e> vjB = new j<e>() {
        protected final /* synthetic */ Object cEE() {
            return new e();
        }
    };
    private boolean Sx;
    private final Handler mHandler;
    private g vjC;
    private final List<k> vjD;
    private d vjE;
    private b vjF;
    private d vjG;
    private final Runnable vjH;
    private final a vjI;

    /* synthetic */ e(byte b) {
        this();
    }

    public static e cFl() {
        return (e) vjB.get();
    }

    private e() {
        this.Sx = false;
        this.vjD = new ArrayList();
        this.vjH = new 2(this);
        this.vjI = new a(this, (byte) 0);
        HandlerThread handlerThread = new HandlerThread("TuringMMCore");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public final synchronized boolean a(d dVar) {
        boolean z = true;
        synchronized (this) {
            Context context = dVar.context;
            if (context == null) {
                z = false;
            } else {
                h cFs = h.cFs();
                if (!cFs.mInit) {
                    cFs.init(context);
                }
                if (this.Sx) {
                    wk();
                }
                this.vjE = dVar;
                this.Sx = true;
                if (this.vjC == null) {
                    this.vjC = new g(context);
                }
                if (this.vjC != null) {
                    g gVar = this.vjC;
                    synchronized (gVar.vjX) {
                        gVar.vjX.clear();
                    }
                }
                synchronized (this.vjD) {
                    this.vjD.clear();
                }
                this.mHandler.postDelayed(this.vjH, dVar.sHg);
            }
        }
        return z;
    }

    public final synchronized boolean wk() {
        boolean z = false;
        synchronized (this) {
            if (this.Sx) {
                this.Sx = false;
                if (this.vjE != null) {
                    this.mHandler.removeCallbacks(this.vjH);
                    this.mHandler.removeCallbacks(this.vjI);
                    if (this.vjC != null) {
                        this.vjC.cFo();
                        if (((int) (this.vjC.vjZ.cFr() / f.vjS)) >= 3) {
                            SparseArray cFp = this.vjC.cFp();
                            if (cFp.size() != 0) {
                                List arrayList;
                                synchronized (this.vjD) {
                                    arrayList = new ArrayList(this.vjD);
                                }
                                if (arrayList.size() >= 3) {
                                    this.mHandler.post(new 3(this, this.vjE.vjz, this.vjE.action, this.vjE.requestType, cFp, arrayList));
                                    z = true;
                                }
                            }
                        }
                    } else {
                        z = true;
                    }
                }
            } else {
                z = true;
            }
        }
        return z;
    }

    public final synchronized void a(Context context, String str, com.tencent.c.e.a.a.e eVar) {
        h cFs = h.cFs();
        if (!cFs.mInit) {
            cFs.init(context);
        }
        this.mHandler.post(new 4(this, eVar, str));
    }
}
