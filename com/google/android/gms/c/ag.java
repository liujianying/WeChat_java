package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ag<T extends ag> {
    public final ah aYi;
    protected final ae aYj;
    private final List<Object> aYk = new ArrayList();

    public ag(ah ahVar, v vVar) {
        w.ah(ahVar);
        this.aYi = ahVar;
        ae aeVar = new ae(this, vVar);
        aeVar.aYf = true;
        this.aYj = aeVar;
    }

    public void a(ae aeVar) {
    }

    public ae oj() {
        ae ql = this.aYj.ql();
        qo();
        return ql;
    }

    public final ae qm() {
        return this.aYj;
    }

    public final List<ai> qn() {
        return this.aYj.aYh;
    }

    public final void qo() {
        Iterator it = this.aYk.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
