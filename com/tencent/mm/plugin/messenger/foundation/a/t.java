package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.bk.a;
import com.tencent.mm.by.c;

public final class t {
    private static SparseArray<a> lcp = new SparseArray();
    private static c<s> lcq;

    public static synchronized <T extends a> void a(int i, r<T> rVar) {
        synchronized (t.class) {
            a aVar = (a) lcp.get(i);
            if (aVar == null) {
                aVar = new a((byte) 0);
                lcp.put(i, aVar);
            }
            aVar.aI(rVar);
        }
    }

    public static synchronized void a(r rVar) {
        synchronized (t.class) {
            a aVar = (a) lcp.get(5);
            if (aVar != null) {
                aVar.remove(rVar);
                if (aVar.size() == 0) {
                    lcp.remove(5);
                }
            }
        }
    }

    public static synchronized <T extends a> void h(T t) {
        synchronized (t.class) {
            a aVar = (a) lcp.get(5);
            if (aVar != null) {
                aVar.f(t);
            }
        }
    }

    public static synchronized <T extends a> void b(int i, T t) {
        synchronized (t.class) {
            a aVar = (a) lcp.get(i);
            if (aVar != null) {
                aVar.e(t);
            }
        }
    }

    public static final c<s> bcZ() {
        return lcq;
    }

    public static final void b(c<s> cVar) {
        lcq = cVar;
    }
}
