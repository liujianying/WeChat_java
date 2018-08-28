package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T> implements Iterator<T> {
    protected final b<T> aMv;
    protected int aMw = -1;

    public e(b<T> bVar) {
        this.aMv = (b) w.ah(bVar);
    }

    public final boolean hasNext() {
        return this.aMw < this.aMv.getCount() + -1;
    }

    public final T next() {
        if (hasNext()) {
            b bVar = this.aMv;
            int i = this.aMw + 1;
            this.aMw = i;
            return bVar.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.aMw);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
