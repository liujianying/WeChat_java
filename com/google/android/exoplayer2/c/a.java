package com.google.android.exoplayer2.c;

public final class a implements j {
    private final long aet;
    public final long[] aiA;
    public final int[] aiy;
    public final long[] aiz;
    public final int length;
    public final long[] offsets;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.aiy = iArr;
        this.offsets = jArr;
        this.aiz = jArr2;
        this.aiA = jArr3;
        this.length = iArr.length;
        if (this.length > 0) {
            this.aet = jArr2[this.length - 1] + jArr3[this.length - 1];
        } else {
            this.aet = 0;
        }
    }

    public final boolean jR() {
        return true;
    }
}
