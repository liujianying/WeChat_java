package com.google.android.gms.analytics.internal;

public abstract class o extends n {
    private boolean aFQ;
    private boolean aFR;

    protected o(q qVar) {
        super(qVar);
    }

    public final boolean isInitialized() {
        return this.aFQ && !this.aFR;
    }

    protected abstract void mE();

    protected final void np() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void nq() {
        mE();
        this.aFQ = true;
    }
}
