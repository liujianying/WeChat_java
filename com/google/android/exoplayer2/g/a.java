package com.google.android.exoplayer2.g;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.l;
import java.util.Arrays;

public abstract class a implements e {
    private int aeo;
    public final Format[] asb;
    protected final l azU;
    protected final int[] azV;
    private final long[] azW;
    public final int length;

    public a(l lVar, int... iArr) {
        int i = 0;
        com.google.android.exoplayer2.i.a.ap(iArr.length > 0);
        this.azU = (l) com.google.android.exoplayer2.i.a.Z(lVar);
        this.length = iArr.length;
        this.asb = new Format[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.asb[i2] = lVar.asb[iArr[i2]];
        }
        Arrays.sort(this.asb, new a((byte) 0));
        this.azV = new int[this.length];
        while (i < this.length) {
            this.azV[i] = lVar.j(this.asb[i]);
            i++;
        }
        this.azW = new long[this.length];
    }

    public final l lG() {
        return this.azU;
    }

    public final int length() {
        return this.azV.length;
    }

    public final Format cS(int i) {
        return this.asb[i];
    }

    public final int cT(int i) {
        return this.azV[i];
    }

    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.azV[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final Format lH() {
        return this.asb[kV()];
    }

    public final int lI() {
        return this.azV[kV()];
    }

    public final boolean cU(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean f = f(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.length && !f) {
            if (i2 == i || f(i2, elapsedRealtime)) {
                f = false;
            } else {
                f = true;
            }
            i2++;
        }
        if (!f) {
            return false;
        }
        this.azW[i] = Math.max(this.azW[i], elapsedRealtime + 60000);
        return true;
    }

    public final boolean f(int i, long j) {
        return this.azW[i] > j;
    }

    public int hashCode() {
        if (this.aeo == 0) {
            this.aeo = (System.identityHashCode(this.azU) * 31) + Arrays.hashCode(this.azV);
        }
        return this.aeo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.azU == aVar.azU && Arrays.equals(this.azV, aVar.azV)) {
            return true;
        }
        return false;
    }
}
