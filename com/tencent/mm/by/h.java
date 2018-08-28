package com.tencent.mm.by;

public final class h<T> {
    private byte[] dol = new byte[0];
    private volatile T mInstance;
    private c<T> uZM;

    public h(c<T> cVar) {
        this.uZM = cVar;
    }

    public final T get() {
        if (this.mInstance == null) {
            synchronized (this.dol) {
                if (this.mInstance == null) {
                    this.mInstance = this.uZM.get();
                }
            }
        }
        return this.mInstance;
    }
}
