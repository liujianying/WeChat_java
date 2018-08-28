package com.google.android.exoplayer2.source;

public final class f$b {
    public static final f$b arT = new f$b(-1, -1, -1);
    public final int arU;
    public final int arV;
    public final int arW;

    public f$b(int i) {
        this(i, -1, -1);
    }

    public f$b(int i, int i2, int i3) {
        this.arU = i;
        this.arV = i2;
        this.arW = i3;
    }

    public final f$b cF(int i) {
        return this.arU == i ? this : new f$b(i, this.arV, this.arW);
    }

    public final boolean kF() {
        return this.arV != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f$b f_b = (f$b) obj;
        if (this.arU == f_b.arU && this.arV == f_b.arV && this.arW == f_b.arW) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.arU + 527) * 31) + this.arV) * 31) + this.arW;
    }
}
