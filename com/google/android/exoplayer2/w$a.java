package com.google.android.exoplayer2;

public final class w$a {
    public int adO;
    public Object adz;
    public Object aeX;
    public long aeY;
    public long[] aeZ;
    public long aet;
    public int[] afa;
    public int[] afb;
    public int[] afc;
    public long[][] afd;
    public long afe;

    public final int iW() {
        return this.aeZ == null ? 0 : this.aeZ.length;
    }

    public final boolean cc(int i) {
        return this.afa[i] != -1 && this.afc[i] == this.afa[i];
    }

    public final int v(long j) {
        if (this.aeZ == null) {
            return -1;
        }
        int length = this.aeZ.length - 1;
        while (length >= 0 && (this.aeZ[length] == Long.MIN_VALUE || this.aeZ[length] > j)) {
            length--;
        }
        if (length < 0 || cc(length)) {
            return -1;
        }
        return length;
    }

    public final int w(long j) {
        if (this.aeZ == null) {
            return -1;
        }
        int i = 0;
        while (i < this.aeZ.length && this.aeZ[i] != Long.MIN_VALUE && (j >= this.aeZ[i] || cc(i))) {
            i++;
        }
        return i >= this.aeZ.length ? -1 : i;
    }

    public final boolean aq(int i, int i2) {
        return i2 < this.afb[i];
    }

    public final long ar(int i, int i2) {
        if (i2 >= this.afd[i].length) {
            return -9223372036854775807L;
        }
        return this.afd[i][i2];
    }
}
