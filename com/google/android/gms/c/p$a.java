package com.google.android.gms.c;

import java.util.Iterator;

final class p$a<T> implements Iterator<T> {
    final /* synthetic */ p aXK;
    int fi;
    int mIndex;
    final int tH;
    boolean tI = false;

    p$a(p pVar, int i) {
        this.aXK = pVar;
        this.tH = i;
        this.fi = pVar.bR();
    }

    public final boolean hasNext() {
        return this.mIndex < this.fi;
    }

    public final T next() {
        T p = this.aXK.p(this.mIndex, this.tH);
        this.mIndex++;
        this.tI = true;
        return p;
    }

    public final void remove() {
        if (this.tI) {
            this.mIndex--;
            this.fi--;
            this.tI = false;
            this.aXK.ac(this.mIndex);
            return;
        }
        throw new IllegalStateException();
    }
}
