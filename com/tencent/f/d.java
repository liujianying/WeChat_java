package com.tencent.f;

public abstract class d<T extends e> {
    public final Object mLock = new Object();
    public int ndo;
    public T[] vwz = cHo();

    public abstract T[] cHo();

    public abstract T cHp();

    public final T cHq() {
        T t = null;
        synchronized (this.mLock) {
            if (this.ndo > 0) {
                this.ndo--;
                t = this.vwz[this.ndo];
                this.vwz[this.ndo] = null;
            }
        }
        return t;
    }
}
