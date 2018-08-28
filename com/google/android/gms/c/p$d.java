package com.google.android.gms.c;

import java.util.Iterator;
import java.util.Map.Entry;

final class p$d implements Iterator<Entry<K, V>>, Entry<K, V> {
    final /* synthetic */ p aXK;
    int mIndex;
    int tK;
    boolean tL = false;

    p$d(p pVar) {
        this.aXK = pVar;
        this.tK = pVar.bR() - 1;
        this.mIndex = -1;
    }

    public final boolean equals(Object obj) {
        if (!this.tL) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            return n.c(entry.getKey(), this.aXK.p(this.mIndex, 0)) && n.c(entry.getValue(), this.aXK.p(this.mIndex, 1));
        }
    }

    public final K getKey() {
        if (this.tL) {
            return this.aXK.p(this.mIndex, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final V getValue() {
        if (this.tL) {
            return this.aXK.p(this.mIndex, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean hasNext() {
        return this.mIndex < this.tK;
    }

    public final int hashCode() {
        int i = 0;
        if (this.tL) {
            Object p = this.aXK.p(this.mIndex, 0);
            Object p2 = this.aXK.p(this.mIndex, 1);
            int hashCode = p == null ? 0 : p.hashCode();
            if (p2 != null) {
                i = p2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.mIndex++;
        this.tL = true;
        return this;
    }

    public final void remove() {
        if (this.tL) {
            this.aXK.ac(this.mIndex);
            this.mIndex--;
            this.tK--;
            this.tL = false;
            return;
        }
        throw new IllegalStateException();
    }

    public final V setValue(V v) {
        if (this.tL) {
            return this.aXK.b(this.mIndex, v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
