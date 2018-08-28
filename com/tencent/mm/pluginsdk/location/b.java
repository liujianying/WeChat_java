package com.tencent.mm.pluginsdk.location;

public final class b {
    public int bSz;
    public float dRS;
    public float dRT;
    public long qyC;
    public int scene;

    public b(long j, float f, float f2, int i, int i2) {
        this.dRS = f;
        this.dRT = f2;
        this.bSz = i;
        this.scene = i2;
        this.qyC = j;
    }

    public final String toString() {
        return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.dRS * 1000000.0f)), Integer.valueOf((int) (this.dRT * 1000000.0f)), Integer.valueOf(this.bSz)});
    }
}
