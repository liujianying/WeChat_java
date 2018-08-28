package com.tencent.pb.common.c;

public abstract class e<T> {
    private T mInstance;

    public abstract T cEE();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = cEE();
            }
            t = this.mInstance;
        }
        return t;
    }
}
