package com.tencent.mm.sdk.platformtools;

public final class ae {
    public volatile boolean sGC;

    public ae() {
        this.sGC = false;
    }

    public ae(boolean z) {
        this.sGC = z;
    }

    public final void open() {
        synchronized (this) {
            boolean z = this.sGC;
            this.sGC = true;
            if (!z) {
                notifyAll();
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.sGC = false;
        }
    }

    public final void block() {
        synchronized (this) {
            while (!this.sGC) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final boolean cih() {
        if (500 != 0) {
            boolean z;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 500 + currentTimeMillis;
                while (!this.sGC && currentTimeMillis < j) {
                    try {
                        wait(j - currentTimeMillis);
                    } catch (InterruptedException e) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                }
                z = this.sGC;
            }
            return z;
        }
        block();
        return true;
    }

    public final String toString() {
        return "MMConditionVariable[" + hashCode() + "," + this.sGC + "]";
    }
}
