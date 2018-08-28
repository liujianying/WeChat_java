package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public abstract class a implements b {
    Context mContext;
    private c uPF = new c();
    public c<Vending> uPG = new c();
    Map<Class, a> uPH = new ConcurrentHashMap();
    byte[] uPI = new byte[0];
    com.tencent.mm.vending.base.a<Object> uPJ = new 1(this);
    private AtomicBoolean uPK = new AtomicBoolean(false);
    boolean uPL = false;
    Map<Class, com.tencent.mm.vending.b.c<b>> uPM = new HashMap();
    public com.tencent.mm.vending.d.a uPN;

    public a() {
        this.uPG.keep(this.uPJ);
        this.uPJ.addVendingDataResolvedCallback(new 2(this));
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.uPF.keep(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.uPM.get(cls);
        if (cVar == null) {
            cVar = new 3(this, d.uRC);
            this.uPM.put(cls, cVar);
        }
        cVar.aI(bVar);
        Object peek = this.uPJ.peek(cls);
        if (peek != null) {
            bVar.be(peek);
        }
    }

    public final <_Struct> _Struct P(Class<_Struct> cls) {
        cBu();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.uPL) {
            synchronized (this.uPI) {
                if (!this.uPL) {
                    try {
                        this.uPI.wait();
                    } catch (Throwable e) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.uPJ.get(cls);
    }

    public final void Q(Class<?> cls) {
        cBu();
        this.uPJ.request(cls);
    }

    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        cBu();
        this.uPH.put(cls, aVar);
    }

    private void cBu() {
        if (Looper.myLooper() == this.uPJ.getLooper() && !this.uPK.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[]{this});
        }
    }

    public void onCreate() {
        this.uPK.set(true);
    }

    public void onDestroy() {
        this.uPF.dead();
        this.uPG.dead();
    }
}
