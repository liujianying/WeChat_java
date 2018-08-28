package com.eclipsesource.a;

import java.util.Iterator;

class b$1 implements Iterator<h> {
    final /* synthetic */ Iterator abA;
    final /* synthetic */ b abB;

    b$1(b bVar, Iterator it) {
        this.abB = bVar;
        this.abA = it;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (h) this.abA.next();
    }

    public final boolean hasNext() {
        return this.abA.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
