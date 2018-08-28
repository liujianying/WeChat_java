package com.google.android.gms.common.internal;

protected abstract class k$c<TListener> {
    private TListener aLM;
    final /* synthetic */ k aOj;
    private boolean aOk = false;

    public k$c(k kVar, TListener tListener) {
        this.aOj = kVar;
        this.aLM = tListener;
    }

    protected abstract void af(TListener tListener);

    public final void pk() {
        Object obj;
        synchronized (this) {
            obj = this.aLM;
            if (this.aOk) {
                new StringBuilder("Callback proxy ").append(this).append(" being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                af(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.aOk = true;
        }
        unregister();
    }

    public final void pl() {
        synchronized (this) {
            this.aLM = null;
        }
    }

    public final void unregister() {
        pl();
        synchronized (k.c(this.aOj)) {
            k.c(this.aOj).remove(this);
        }
    }
}
