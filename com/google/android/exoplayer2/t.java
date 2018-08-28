package com.google.android.exoplayer2;

public final class t {
    public static final t aez = new t(0);
    public final int aeA;

    public t(int i) {
        this.aeA = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.aeA != ((t) obj).aeA) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.aeA;
    }
}
