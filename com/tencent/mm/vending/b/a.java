package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    protected d byz;
    private LinkedList<b> uQy;
    public f uQz;

    public a() {
        this(g.cBM());
    }

    public a(d dVar) {
        this.uQy = new LinkedList();
        Assert.assertNotNull(dVar);
        this.byz = dVar;
        this.uQz = new f(dVar, null);
    }

    public final synchronized b a(b bVar) {
        this.uQy.add(bVar);
        return bVar;
    }

    public final synchronized void b(b bVar) {
        if (bVar != null) {
            this.uQy.remove(bVar);
        }
    }

    public final synchronized LinkedList<b> cBB() {
        return new LinkedList(this.uQy);
    }

    public final synchronized int size() {
        return this.uQy.size();
    }

    public final synchronized boolean contains(_Callback _callback) {
        return this.uQy.contains(new b(_callback, this));
    }
}
