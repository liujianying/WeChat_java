package com.google.android.exoplayer2.c.c;

public final class u$d {
    private String amX;
    private final String apk;
    private final int apl;
    private final int apm;
    private int apn;

    public u$d() {
        this(Integer.MIN_VALUE, 0, 1);
    }

    public u$d(int i, int i2, int i3) {
        this.apk = i != Integer.MIN_VALUE ? i + "/" : "";
        this.apl = i2;
        this.apm = i3;
        this.apn = Integer.MIN_VALUE;
    }

    public final void kf() {
        this.apn = this.apn == Integer.MIN_VALUE ? this.apl : this.apn + this.apm;
        this.amX = this.apk + this.apn;
    }

    public final int kg() {
        ki();
        return this.apn;
    }

    public final String kh() {
        ki();
        return this.amX;
    }

    private void ki() {
        if (this.apn == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }
}
