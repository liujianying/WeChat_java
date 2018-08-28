package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class m implements p {
    final o aKG;
    final Lock aKI;
    private ConnectionResult aKJ;
    private int aKK;
    private int aKL = 0;
    private boolean aKM = false;
    private int aKN;
    private final Bundle aKO = new Bundle();
    private final Set<c> aKP = new HashSet();
    d aKQ;
    private int aKR;
    boolean aKS;
    boolean aKT;
    p aKU;
    boolean aKV;
    boolean aKW;
    private final com.google.android.gms.common.internal.h aKX;
    private final Map<a<?>, Integer> aKY;
    private ArrayList<Future<?>> aKZ = new ArrayList();
    private final b aKf;
    private final a<? extends d, e> aKg;
    final Context mContext;

    private abstract class i implements Runnable {
        private i() {
        }

        /* synthetic */ i(m mVar, byte b) {
            this();
        }

        protected abstract void oI();

        public void run() {
            m.this.aKI.lock();
            try {
                if (!Thread.interrupted()) {
                    oI();
                    m.this.aKI.unlock();
                }
            } catch (RuntimeException e) {
                o oVar = m.this.aKG;
                oVar.aLu.sendMessage(oVar.aLu.obtainMessage(4, e));
            } finally {
                m.this.aKI.unlock();
            }
        }
    }

    private class h extends i {
        private final ArrayList<a.b> aLn;

        public h(ArrayList<a.b> arrayList) {
            super(m.this, (byte) 0);
            this.aLn = arrayList;
        }

        public final void oI() {
            Iterator it = this.aLn.iterator();
            while (it.hasNext()) {
                ((a.b) it.next()).a(m.this.aKU);
            }
        }
    }

    public m(o oVar, com.google.android.gms.common.internal.h hVar, Map<a<?>, Integer> map, b bVar, a<? extends d, e> aVar, Lock lock, Context context) {
        this.aKG = oVar;
        this.aKX = hVar;
        this.aKY = map;
        this.aKf = bVar;
        this.aKg = aVar;
        this.aKI = lock;
        this.mContext = context;
    }

    private void as(boolean z) {
        if (this.aKQ != null) {
            if (this.aKQ.isConnected() && z) {
                this.aKQ.qT();
            }
            this.aKQ.disconnect();
            this.aKU = null;
        }
    }

    private static String do(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void oN() {
        boolean z = true;
        o oVar = this.aKG;
        oVar.aKI.lock();
        try {
            oVar.oS();
            oVar.aLz = new l(oVar);
            oVar.aLz.begin();
            oVar.aLo.signalAll();
            q.oT().execute(new 1(this));
            if (this.aKQ != null) {
                if (this.aKV) {
                    this.aKQ.a(this.aKU, this.aKW);
                }
                as(false);
            }
            for (c cVar : this.aKG.aLx.keySet()) {
                ((a.b) this.aKG.aLw.get(cVar)).disconnect();
            }
            if (this.aKM) {
                this.aKM = false;
                disconnect();
                return;
            }
            Bundle bundle = this.aKO.isEmpty() ? null : this.aKO;
            l lVar = this.aKG.aLp;
            w.d(Looper.myLooper() == lVar.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
            synchronized (lVar.aNW) {
                w.at(!lVar.aOu);
                lVar.mHandler.removeMessages(1);
                lVar.aOu = true;
                if (lVar.aOq.size() != 0) {
                    z = false;
                }
                w.at(z);
                ArrayList arrayList = new ArrayList(lVar.aOp);
                int i = lVar.aOt.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b bVar = (c.b) it.next();
                    if (lVar.aOs && lVar.aOo.isConnected() && lVar.aOt.get() == i) {
                        if (!lVar.aOq.contains(bVar)) {
                            bVar.e(bundle);
                        }
                    }
                }
                lVar.aOq.clear();
                lVar.aOu = false;
            }
        } finally {
            oVar.aKI.unlock();
        }
    }

    private void oP() {
        Iterator it = this.aKZ.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.aKZ.clear();
    }

    public final <A extends a.b, R extends g, T extends k$a<R, A>> T a(T t) {
        this.aKG.aLq.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
        if (dn(3)) {
            b(connectionResult, aVar, i);
            if (oJ()) {
                oN();
            }
        }
    }

    public final <A extends a.b, T extends k$a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.a<?> r6, int r7) {
        /*
        r4 = this;
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = 0;
        r0 = 1;
        r2 = 2;
        if (r7 == r2) goto L_0x0024;
    L_0x0008:
        r6.or();
        if (r7 != r0) goto L_0x0016;
    L_0x000d:
        r2 = r5.op();
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        r2 = r0;
    L_0x0014:
        if (r2 == 0) goto L_0x003c;
    L_0x0016:
        r2 = r4.aKJ;
        if (r2 == 0) goto L_0x001e;
    L_0x001a:
        r2 = r4.aKK;
        if (r3 >= r2) goto L_0x003c;
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r4.aKJ = r5;
        r4.aKK = r3;
    L_0x0024:
        r0 = r4.aKG;
        r0 = r0.aLx;
        r1 = r6.os();
        r0.put(r1, r5);
        return;
    L_0x0030:
        r2 = r5.aJC;
        r2 = com.google.android.gms.common.b.di(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x0038:
        r2 = r0;
        goto L_0x0014;
    L_0x003a:
        r2 = r1;
        goto L_0x0014;
    L_0x003c:
        r0 = r1;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.m.b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.a, int):void");
    }

    public final void begin() {
        this.aKG.aLp.aOs = true;
        this.aKG.aLx.clear();
        this.aKM = false;
        this.aKS = false;
        this.aKJ = null;
        this.aKL = 0;
        this.aKR = 2;
        this.aKT = false;
        this.aKV = false;
        Map hashMap = new HashMap();
        for (a aVar : this.aKY.keySet()) {
            a.b bVar = (a.b) this.aKG.aLw.get(aVar.os());
            int intValue = ((Integer) this.aKY.get(aVar)).intValue();
            aVar.or();
            if (bVar.ou()) {
                this.aKS = true;
                if (intValue < this.aKR) {
                    this.aKR = intValue;
                }
                if (intValue != 0) {
                    this.aKP.add(aVar.os());
                }
            }
            hashMap.put(bVar, new d(this, aVar, intValue));
        }
        if (this.aKS) {
            this.aKX.aNR = Integer.valueOf(System.identityHashCode(this.aKG));
            g gVar = new g(this, (byte) 0);
            this.aKQ = (d) this.aKg.a(this.mContext, this.aKG.aKe, this.aKX, this.aKX.aNQ, gVar, gVar);
        }
        this.aKN = this.aKG.aLw.size();
        this.aKZ.add(q.oT().submit(new e(this, hashMap)));
    }

    public final void connect() {
        this.aKM = false;
    }

    final boolean d(ConnectionResult connectionResult) {
        return this.aKR != 2 ? this.aKR == 1 && !connectionResult.op() : true;
    }

    public final void disconnect() {
        Iterator it = this.aKG.aLq.iterator();
        while (it.hasNext()) {
            ((o.e) it.next()).cancel();
            it.remove();
        }
        this.aKG.oR();
        if (this.aKJ != null || this.aKG.aLq.isEmpty()) {
            oP();
            as(true);
            this.aKG.aLx.clear();
            this.aKG.f(null);
            this.aKG.aLp.pm();
            return;
        }
        this.aKM = true;
    }

    public final void dm(int i) {
        e(new ConnectionResult(8, null));
    }

    final boolean dn(int i) {
        if (this.aKL == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + do(this.aKL) + " but received callback for step " + do(i));
        e(new ConnectionResult(8, null));
        return false;
    }

    public final void e(Bundle bundle) {
        if (dn(3)) {
            if (bundle != null) {
                this.aKO.putAll(bundle);
            }
            if (oJ()) {
                oN();
            }
        }
    }

    final void e(ConnectionResult connectionResult) {
        boolean z = false;
        this.aKM = false;
        oP();
        as(!connectionResult.op());
        this.aKG.aLx.clear();
        this.aKG.f(connectionResult);
        if (!this.aKG.aLr || !b.p(this.mContext, connectionResult.aJC)) {
            this.aKG.oS();
            l lVar = this.aKG.aLp;
            if (Looper.myLooper() == lVar.mHandler.getLooper()) {
                z = true;
            }
            w.d(z, "onConnectionFailure must only be called on the Handler thread");
            lVar.mHandler.removeMessages(1);
            synchronized (lVar.aNW) {
                ArrayList arrayList = new ArrayList(lVar.aOr);
                int i = lVar.aOt.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.c cVar = (c.c) it.next();
                    if (!lVar.aOs || lVar.aOt.get() != i) {
                        break;
                    } else if (lVar.aOr.contains(cVar)) {
                        cVar.a(connectionResult);
                    }
                }
            }
        }
        this.aKG.aLp.pm();
    }

    public final String getName() {
        return "CONNECTING";
    }

    final boolean oJ() {
        this.aKN--;
        if (this.aKN > 0) {
            return false;
        }
        if (this.aKN < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            e(new ConnectionResult(8, null));
            return false;
        } else if (this.aKJ == null) {
            return true;
        } else {
            e(this.aKJ);
            return false;
        }
    }

    final void oK() {
        if (this.aKN == 0) {
            if (!this.aKS) {
                oM();
            } else if (this.aKT) {
                ArrayList arrayList = new ArrayList();
                this.aKL = 1;
                this.aKN = this.aKG.aLw.size();
                for (c cVar : this.aKG.aLw.keySet()) {
                    if (!this.aKG.aLx.containsKey(cVar)) {
                        arrayList.add(this.aKG.aLw.get(cVar));
                    } else if (oJ()) {
                        oL();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.aKZ.add(q.oT().submit(new h(arrayList)));
                }
            }
        }
    }

    final void oL() {
        this.aKL = 2;
        this.aKG.aLy = oQ();
        this.aKZ.add(q.oT().submit(new c(this, (byte) 0)));
    }

    final void oM() {
        ArrayList arrayList = new ArrayList();
        this.aKL = 3;
        this.aKN = this.aKG.aLw.size();
        for (c cVar : this.aKG.aLw.keySet()) {
            if (!this.aKG.aLx.containsKey(cVar)) {
                arrayList.add(this.aKG.aLw.get(cVar));
            } else if (oJ()) {
                oN();
            }
        }
        if (!arrayList.isEmpty()) {
            this.aKZ.add(q.oT().submit(new f(this, arrayList)));
        }
    }

    final void oO() {
        this.aKS = false;
        this.aKG.aLy = Collections.emptySet();
        for (c cVar : this.aKP) {
            if (!this.aKG.aLx.containsKey(cVar)) {
                this.aKG.aLx.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    final Set<Scope> oQ() {
        Set<Scope> hashSet = new HashSet(this.aKX.aJT);
        Map map = this.aKX.aNP;
        for (a aVar : map.keySet()) {
            if (!this.aKG.aLx.containsKey(aVar.os())) {
                hashSet.addAll(((com.google.android.gms.common.internal.h.a) map.get(aVar)).aKn);
            }
        }
        return hashSet;
    }
}
