package com.tencent.mm.kernel.c;

public final class e<T extends a> implements b, c<T> {
    private T dta;

    public e(T t) {
        this.dta = t;
    }

    public final T EV() {
        return this.dta;
    }

    public final void ET() {
        if (this.dta instanceof b) {
            ((b) this.dta).ET();
        }
    }

    public final void EU() {
        if (this.dta instanceof b) {
            ((b) this.dta).EU();
        }
    }
}
