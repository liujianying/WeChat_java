package com.tencent.mm.kernel.a.a;

import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T> {
    public final ConcurrentHashMap<T, a<T>> drY = new ConcurrentHashMap();

    public static class a<T> {
        private HashSet<a> drZ;
        private HashSet<a> dsa;
        public T dsb;
        public volatile boolean dsc = false;
        private boolean dsd = true;

        public a(T t) {
            this.dsb = t;
        }

        public final synchronized HashSet<a> Ew() {
            return this.dsa == null ? null : new HashSet(this.dsa);
        }

        public final synchronized HashSet<a> Ex() {
            return this.drZ == null ? null : new HashSet(this.drZ);
        }

        public final synchronized int Ey() {
            return this.drZ == null ? 0 : this.drZ.size();
        }

        public final synchronized boolean Ez() {
            return this.dsd;
        }

        public final synchronized void EA() {
            if (this.drZ == null || this.drZ.size() == 0) {
                this.dsd = true;
            }
        }

        public final synchronized boolean EB() {
            boolean z;
            z = this.drZ != null && this.drZ.size() > 0;
            return z;
        }

        public String toString() {
            return "Ref-" + this.dsb.toString();
        }

        public void a(a aVar) {
            b(aVar);
            aVar.c(this);
        }

        private synchronized void b(a aVar) {
            this.dsd = false;
            if (this.drZ == null) {
                this.drZ = new HashSet(4);
            }
            this.drZ.add(aVar);
        }

        private synchronized void c(a aVar) {
            if (this.dsa == null) {
                this.dsa = new HashSet(4);
            }
            this.dsa.add(aVar);
        }

        public int hashCode() {
            return this.dsb.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.dsb.equals(((a) obj).dsb);
            }
            return this.dsb.equals(obj);
        }
    }

    public a<T> aJ(T t) {
        if (!this.drY.containsKey(t)) {
            this.drY.putIfAbsent(t, new a(t));
        }
        return (a) this.drY.get(t);
    }

    public final a<T> aK(T t) {
        return (a) this.drY.get(t);
    }

    private static void aL(T t) {
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.aE(t));
    }

    public final void p(T t, T t2) {
        Object[] objArr = new Object[]{t, t2};
        aL(t);
        aL(t2);
        if (t == t2) {
            aJ(t).EA();
        } else {
            aJ(t).a(aJ(t2));
        }
    }
}
