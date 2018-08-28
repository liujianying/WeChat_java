package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends h implements Iterable<h> {
    public final List<h> abz = new ArrayList();

    public final b bY(int i) {
        this.abz.add(a.bX(i));
        return this;
    }

    public final b l(long j) {
        this.abz.add(a.k(j));
        return this;
    }

    public final b m(double d) {
        this.abz.add(a.l(d));
        return this;
    }

    public final b ad(boolean z) {
        this.abz.add(a.ac(z));
        return this;
    }

    public final b a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("value is null");
        }
        this.abz.add(hVar);
        return this;
    }

    public final h bZ(int i) {
        return (h) this.abz.get(i);
    }

    public final Iterator<h> iterator() {
        return new 1(this, this.abz.iterator());
    }

    final void a(i iVar) {
        iVar.if();
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                iVar.ih();
            }
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.ig();
    }

    public final boolean isArray() {
        return true;
    }

    public final b hQ() {
        return this;
    }

    public final int hashCode() {
        return this.abz.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.abz.equals(((b) obj).abz);
    }
}
