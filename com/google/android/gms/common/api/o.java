package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.h$a;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.l.a;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o implements c {
    final Lock aKI = new ReentrantLock();
    final h aKX;
    final Map<a<?>, Integer> aKY;
    private final int aKb;
    private final int aKc;
    final Looper aKe;
    final com.google.android.gms.common.b aKf;
    final a$a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aKg;
    private ConnectionResult aLA = null;
    private final Set<r<?>> aLB = Collections.newSetFromMap(new WeakHashMap());
    final Set<e<?>> aLC = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final d aLD = new 1(this);
    private final com.google.android.gms.common.api.c.b aLE = new 2(this);
    private final a aLF = new 3(this);
    final Condition aLo;
    final l aLp;
    final Queue<e<?>> aLq = new LinkedList();
    volatile boolean aLr;
    long aLs = 120000;
    long aLt = 5000;
    final a aLu;
    BroadcastReceiver aLv;
    final Map<a$c<?>, com.google.android.gms.common.api.a.b> aLw = new HashMap();
    final Map<a$c<?>, ConnectionResult> aLx = new HashMap();
    Set<Scope> aLy = new HashSet();
    volatile p aLz;
    final Context mContext;

    static abstract class b {
        private final p aLJ;

        protected b(p pVar) {
            this.aLJ = pVar;
        }

        public final void b(o oVar) {
            oVar.aKI.lock();
            try {
                if (oVar.aLz == this.aLJ) {
                    oI();
                    oVar.aKI.unlock();
                }
            } finally {
                oVar.aKI.unlock();
            }
        }

        protected abstract void oI();
    }

    interface d {
        void c(e<?> eVar);
    }

    interface e<A extends com.google.android.gms.common.api.a.b> {
        void a(Status status);

        void a(A a);

        void a(d dVar);

        void c(Status status);

        void cancel();

        a$c<A> os();
    }

    public o(Context context, Looper looper, h hVar, com.google.android.gms.common.b bVar, a$a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> a_a, Map<a<?>, Object> map, ArrayList<com.google.android.gms.common.api.c.b> arrayList, ArrayList<c> arrayList2, int i, int i2) {
        this.mContext = context;
        this.aLp = new l(looper, this.aLF);
        this.aKe = looper;
        this.aLu = new a(this, looper);
        this.aKf = bVar;
        this.aKb = i;
        this.aKc = i2;
        this.aKY = new HashMap();
        this.aLo = this.aKI.newCondition();
        this.aLz = new n(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.aLp.a((com.google.android.gms.common.api.c.b) it.next());
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.aLp.a((c) it.next());
        }
        Map map2 = hVar.aNP;
        for (a aVar : map.keySet()) {
            int i3;
            Object cVar;
            Object obj = map.get(aVar);
            if (map2.get(aVar) != null) {
                i3 = ((h$a) map2.get(aVar)).aNS ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.aKY.put(aVar, Integer.valueOf(i3));
            if ((aVar.aJS != null ? 1 : null) != null) {
                w.d(aVar.aJQ != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
                a$e a_e = aVar.aJQ;
                cVar = new com.google.android.gms.common.internal.c(context, looper, a_e.oA(), this.aLE, a(aVar, i3), hVar, a_e.oz());
            } else {
                cVar = aVar.or().a(context, looper, hVar, obj, this.aLE, a(aVar, i3));
            }
            this.aLw.put(aVar.os(), cVar);
        }
        this.aKX = hVar;
        this.aKg = a_a;
    }

    private final c a(a<?> aVar, int i) {
        return new 4(this, aVar, i);
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        w.d(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.aKI.lock();
        try {
            connect();
            long toNanos = timeUnit.toNanos(30);
            while (this.aLz instanceof m) {
                toNanos = this.aLo.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (this.aLz instanceof l) {
                connectionResult = ConnectionResult.aJB;
                this.aKI.unlock();
            } else if (this.aLA != null) {
                connectionResult = this.aLA;
                this.aKI.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.aKI.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.aKI.unlock();
        }
        return connectionResult;
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends k.a<R, A>> T a(T t) {
        w.e(t.aJR != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        w.e(this.aLw.containsKey(t.aJR), "GoogleApiClient is not configured to use the API required for this call.");
        this.aKI.lock();
        try {
            T a = this.aLz.a(t);
            return a;
        } finally {
            this.aKI.unlock();
        }
    }

    public final void a(com.google.android.gms.common.api.c.b bVar) {
        this.aLp.a(bVar);
    }

    public final void a(c cVar) {
        this.aLp.a(cVar);
    }

    final void a(b bVar) {
        this.aLu.sendMessage(this.aLu.obtainMessage(3, bVar));
    }

    public final void a(String str, PrintWriter printWriter) {
        printWriter.append(str).append("mState=").append(this.aLz.getName());
        printWriter.append(" mResuming=").print(this.aLr);
        printWriter.append(" mWorkQueue.size()=").print(this.aLq.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.aLC.size());
        String str2 = str + "  ";
        for (a aVar : this.aKY.keySet()) {
            printWriter.append(str).append(aVar.mName).println(":");
            ((com.google.android.gms.common.api.a.b) this.aLw.get(aVar.os())).a(str2, printWriter);
        }
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends k.a<? extends g, A>> T b(T t) {
        w.e(t.aJR != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.aKI.lock();
        try {
            if (this.aLr) {
                this.aLq.add(t);
                while (!this.aLq.isEmpty()) {
                    e eVar = (e) this.aLq.remove();
                    b(eVar);
                    eVar.c(Status.aKr);
                }
            } else {
                t = this.aLz.b(t);
                this.aKI.unlock();
            }
            return t;
        } finally {
            this.aKI.unlock();
        }
    }

    public final void b(com.google.android.gms.common.api.c.b bVar) {
        l lVar = this.aLp;
        w.ah(bVar);
        synchronized (lVar.aNW) {
            if (!lVar.aOp.remove(bVar)) {
                new StringBuilder("unregisterConnectionCallbacks(): listener ").append(bVar).append(" not found");
            } else if (lVar.aOu) {
                lVar.aOq.add(bVar);
            }
        }
    }

    public final void b(c cVar) {
        l lVar = this.aLp;
        w.ah(cVar);
        synchronized (lVar.aNW) {
            if (!lVar.aOr.remove(cVar)) {
                new StringBuilder("unregisterConnectionFailedListener(): listener ").append(cVar).append(" not found");
            }
        }
    }

    final <A extends com.google.android.gms.common.api.a.b> void b(e<A> eVar) {
        this.aLC.add(eVar);
        eVar.a(this.aLD);
    }

    public final void connect() {
        this.aKI.lock();
        try {
            this.aLz.connect();
        } finally {
            this.aKI.unlock();
        }
    }

    public final void disconnect() {
        this.aKI.lock();
        try {
            oS();
            this.aLz.disconnect();
        } finally {
            this.aKI.unlock();
        }
    }

    final void f(ConnectionResult connectionResult) {
        this.aKI.lock();
        try {
            this.aLA = connectionResult;
            this.aLz = new n(this);
            this.aLz.begin();
            this.aLo.signalAll();
        } finally {
            this.aKI.unlock();
        }
    }

    public final Looper getLooper() {
        return this.aKe;
    }

    public final boolean isConnected() {
        return this.aLz instanceof l;
    }

    public final boolean isConnecting() {
        return this.aLz instanceof m;
    }

    final void oR() {
        for (e eVar : this.aLC) {
            eVar.a(null);
            eVar.cancel();
        }
        this.aLC.clear();
        for (r rVar : this.aLB) {
            rVar.aLM = null;
        }
        this.aLB.clear();
    }

    final boolean oS() {
        if (!this.aLr) {
            return false;
        }
        this.aLr = false;
        this.aLu.removeMessages(2);
        this.aLu.removeMessages(1);
        if (this.aLv != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.aLv);
            this.aLv = null;
        }
        return true;
    }
}
