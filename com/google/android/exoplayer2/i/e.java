package com.google.android.exoplayer2.i;

import java.util.Arrays;

public final class e {
    private long[] aCc;
    private int size;

    public e() {
        this((byte) 0);
    }

    private e(byte b) {
        this.aCc = new long[32];
    }

    public final void add(long j) {
        if (this.size == this.aCc.length) {
            this.aCc = Arrays.copyOf(this.aCc, this.size * 2);
        }
        long[] jArr = this.aCc;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public final long[] toArray() {
        return Arrays.copyOf(this.aCc, this.size);
    }
}
