package com.tencent.mm.bs;

import com.tencent.mm.bs.b.b;
import java.util.HashSet;
import java.util.Iterator;

public class a<T> implements b<T> {
    private final String mName;
    private T sNA;
    private HashSet<com.tencent.mm.bs.b.a<T>> sNB;
    private final Object sNC;

    private a(String str) {
        this.sNC = new Object();
        this.mName = str;
        this.sNB = new HashSet();
    }

    a(String str, T t) {
        this(str);
        this.sNA = t;
    }

    public final String name() {
        return this.mName;
    }

    public final T get() {
        return this.sNA;
    }

    final void set(T t) {
        T t2 = this.sNA;
        Object obj = (t == t2 || (t != null && t.equals(t2))) ? 1 : null;
        if (obj == null) {
            this.sNA = t;
            synchronized (this.sNC) {
                Iterator it = this.sNB.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.bs.b.a) it.next()).aZ(t);
                }
            }
        }
    }

    public final void a(com.tencent.mm.bs.b.a<T> aVar) {
        boolean add;
        synchronized (this.sNC) {
            add = this.sNB.add(aVar);
        }
        if (add) {
            c(aVar);
        }
    }

    public final void b(com.tencent.mm.bs.b.a<T> aVar) {
        boolean remove;
        synchronized (this.sNC) {
            remove = this.sNB.remove(aVar);
        }
        if (remove) {
            d(aVar);
        }
    }

    public final void removeAllListeners() {
        HashSet hashSet;
        synchronized (this.sNC) {
            hashSet = this.sNB;
            this.sNB = new HashSet();
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            d((com.tencent.mm.bs.b.a) it.next());
        }
    }

    protected void c(com.tencent.mm.bs.b.a<T> aVar) {
    }

    protected void d(com.tencent.mm.bs.b.a<T> aVar) {
    }

    public String toString() {
        return "Status: " + this.mName;
    }
}
