package com.tencent.matrix.iocanary.a;

public final class a {
    public static final a bqL;
    public final int bqM;
    public final int bqN;
    private final int bqO;
    public final int bqP;
    private final int mask;

    public static final class a {
        int bpd = -1;
        int bqQ = 500;
        int bqR = 4096;
        int bqS = 20;
        int bqT = 5;
    }

    private /* synthetic */ a(int i, int i2, int i3, int i4, int i5, byte b) {
        this(i, i2, i3, i4, i5);
    }

    static {
        a aVar = new a();
        bqL = new a(aVar.bpd, aVar.bqQ, aVar.bqR, aVar.bqS, aVar.bqT, (byte) 0);
    }

    private a(int i, int i2, int i3, int i4, int i5) {
        this.mask = i;
        this.bqM = i2;
        this.bqO = i4;
        this.bqN = i3;
        this.bqP = i5;
    }

    public final boolean el(int i) {
        return (this.mask & i) > 0;
    }

    public final String toString() {
        return String.format("[IOCanary.IOConfig;mask=%d]", new Object[]{Integer.valueOf(this.mask)});
    }
}
