package com.google.android.exoplayer2.i;

public final class q {
    private long aCF;
    public volatile long aCG = -9223372036854775807L;
    public long amH;

    public q(long j) {
        S(j);
    }

    public final synchronized void S(long j) {
        a.ap(this.aCG == -9223372036854775807L);
        this.amH = j;
    }

    public final long mp() {
        if (this.amH == Long.MAX_VALUE) {
            return 0;
        }
        return this.aCG != -9223372036854775807L ? this.aCF : -9223372036854775807L;
    }

    public final long T(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2;
        if (this.aCG != -9223372036854775807L) {
            long W = W(this.aCG);
            long j3 = (4294967296L + W) / 8589934592L;
            j2 = ((j3 - 1) * 8589934592L) + j;
            j3 = (j3 * 8589934592L) + j;
            if (Math.abs(j2 - W) >= Math.abs(j3 - W)) {
                j2 = j3;
            }
        } else {
            j2 = j;
        }
        return U(V(j2));
    }

    public final long U(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.aCG != -9223372036854775807L) {
            this.aCG = j;
        } else {
            if (this.amH != Long.MAX_VALUE) {
                this.aCF = this.amH - j;
            }
            synchronized (this) {
                this.aCG = j;
                notifyAll();
            }
        }
        return this.aCF + j;
    }

    public final synchronized void mq() {
        while (this.aCG == -9223372036854775807L) {
            wait();
        }
    }

    public static long V(long j) {
        return (1000000 * j) / 90000;
    }

    public static long W(long j) {
        return (90000 * j) / 1000000;
    }
}
