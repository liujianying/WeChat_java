package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class k<T, E> {
    public int sKF = 0;
    private final Hashtable<T, Object> sKG = new Hashtable();
    private final HashSet<E> sKH = new HashSet();

    public abstract void q(T t, E e);

    public final void lock() {
        this.sKF++;
    }

    public final void unlock() {
        this.sKF--;
        if (this.sKF <= 0) {
            this.sKF = 0;
            cjv();
        }
    }

    public final boolean isLocked() {
        return this.sKF > 0;
    }

    public synchronized void a(T t, Looper looper) {
        if (!this.sKG.containsKey(t)) {
            if (looper != null) {
                this.sKG.put(t, looper);
            } else {
                this.sKG.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.sKG.remove(t);
    }

    public final synchronized void removeAll() {
        this.sKG.clear();
    }

    private synchronized Vector<T> cju() {
        Vector<T> vector;
        vector = new Vector();
        vector.addAll(this.sKG.keySet());
        return vector;
    }

    public final boolean ci(E e) {
        boolean add;
        synchronized (this.sKH) {
            add = this.sKH.add(e);
        }
        return add;
    }

    public final void doNotify() {
        if (!isLocked()) {
            cjv();
        }
    }

    public void cY(List<E> list) {
    }

    private void cjv() {
        Vector cju = cju();
        if (cju.size() <= 0) {
            this.sKH.clear();
            return;
        }
        Object arrayList;
        synchronized (this.sKH) {
            arrayList = new ArrayList(this.sKH);
            this.sKH.clear();
        }
        cY(arrayList);
        Map hashMap = new HashMap();
        Iterator it = cju.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.sKG.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        ag agVar = (ag) hashMap.get(looper);
                        if (agVar == null) {
                            agVar = new ag(looper);
                            hashMap.put(looper, agVar);
                        }
                        agVar.post(new Runnable() {
                            public final void run() {
                                k.this.q(next, next2);
                            }
                        });
                    } else {
                        q(next, next2);
                    }
                }
            }
        }
    }
}
