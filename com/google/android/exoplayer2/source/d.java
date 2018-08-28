package com.google.android.exoplayer2.source;

public final class d implements j {
    private final j[] arS;

    public d(j[] jVarArr) {
        this.arS = jVarArr;
    }

    public final long kA() {
        long j = Long.MAX_VALUE;
        for (j kA : this.arS) {
            long kA2 = kA.kA();
            if (kA2 != Long.MIN_VALUE) {
                j = Math.min(j, kA2);
            }
        }
        return j == Long.MAX_VALUE ? Long.MIN_VALUE : j;
    }

    public final long kB() {
        long j = Long.MAX_VALUE;
        for (j kB : this.arS) {
            long kB2 = kB.kB();
            if (kB2 != Long.MIN_VALUE) {
                j = Math.min(j, kB2);
            }
        }
        return j == Long.MAX_VALUE ? Long.MIN_VALUE : j;
    }

    public final boolean G(long j) {
        boolean z = false;
        int i;
        do {
            long kB = kB();
            if (kB == Long.MIN_VALUE) {
                break;
            }
            i = 0;
            for (j jVar : this.arS) {
                if (jVar.kB() == kB) {
                    i |= jVar.G(j);
                }
            }
            z |= i;
        } while (i != 0);
        return z;
    }
}
