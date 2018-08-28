package com.google.android.exoplayer2.b;

public abstract class a {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean jx() {
        return cg(Integer.MIN_VALUE);
    }

    public final boolean jy() {
        return cg(4);
    }

    public final boolean jz() {
        return cg(1);
    }

    public final void cf(int i) {
        this.flags |= i;
    }

    protected final boolean cg(int i) {
        return (this.flags & i) == i;
    }
}
