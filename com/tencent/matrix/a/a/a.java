package com.tencent.matrix.a.a;

public final class a {
    public static final a boX = new a().th();
    public final int boY;
    public final int boZ;
    public final int bpa;
    public final int bpb;
    public final int bpc;
    private final int mask;

    public static final class a {
        private int bpd = 0;
        private int bpe = 120000;
        private int bpf = 20;
        private int bpg = 600000;
        private int bph = 20;
        private int bpi = 12;

        public final a em(int i) {
            this.bpd |= i;
            return this;
        }

        public final a th() {
            return new a(this.bpd, this.bpe, this.bpf, this.bpg, this.bph, this.bpi, (byte) 0);
        }
    }

    /* synthetic */ a(int i, int i2, int i3, int i4, int i5, int i6, byte b) {
        this(i, i2, i3, i4, i5, i6);
    }

    private a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mask = i;
        this.boY = i2;
        this.boZ = i3;
        this.bpa = i4;
        this.bpb = i5;
        this.bpc = i6;
    }

    public final boolean el(int i) {
        return (this.mask & i) > 0;
    }

    public final String toString() {
        return String.format("[BatteryCanary.BatteryConfig;mask=%d]", new Object[]{Integer.valueOf(this.mask)});
    }
}
