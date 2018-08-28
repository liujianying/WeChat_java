package com.eclipsesource.a;

import com.eclipsesource.a.e.b;
import java.util.Iterator;

class e$1 implements Iterator<b> {
    final /* synthetic */ Iterator abH;
    final /* synthetic */ Iterator abI;
    final /* synthetic */ e abJ;

    e$1(e eVar, Iterator it, Iterator it2) {
        this.abJ = eVar;
        this.abH = it;
        this.abI = it2;
    }

    public final /* synthetic */ Object next() {
        return new b((String) this.abH.next(), (h) this.abI.next());
    }

    public final boolean hasNext() {
        return this.abH.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
