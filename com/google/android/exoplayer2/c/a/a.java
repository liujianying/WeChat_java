package com.google.android.exoplayer2.c.a;

final class a implements com.google.android.exoplayer2.c.a.b.a {
    private final long aet;
    private final long aiT;
    private final int bitrate;

    public a(long j, int i, long j2) {
        this.aiT = j;
        this.bitrate = i;
        this.aet = j2 == -1 ? -9223372036854775807L : C(j2);
    }

    public final boolean jR() {
        return this.aet != -9223372036854775807L;
    }

    public final long C(long j) {
        return ((Math.max(0, j - this.aiT) * 1000000) * 8) / ((long) this.bitrate);
    }
}
