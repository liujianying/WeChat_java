package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T> implements b<T> {
    public final DataHolder aMb;

    protected a(DataHolder dataHolder) {
        this.aMb = dataHolder;
        if (this.aMb != null) {
            this.aMb.aMn = this;
        }
    }

    public int getCount() {
        return this.aMb == null ? 0 : this.aMb.aMm;
    }

    public Iterator<T> iterator() {
        return new e(this);
    }

    public final void release() {
        if (this.aMb != null) {
            this.aMb.close();
        }
    }
}
