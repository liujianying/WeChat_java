package com.google.android.exoplayer2.c;

import java.util.Arrays;

public final class k$a {
    public final int ahT;
    public final int ahU;
    public final int aiR;
    public final byte[] aiS;

    public k$a(int i, byte[] bArr, int i2, int i3) {
        this.aiR = i;
        this.aiS = bArr;
        this.ahT = i2;
        this.ahU = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k$a k_a = (k$a) obj;
        if (this.aiR == k_a.aiR && this.ahT == k_a.ahT && this.ahU == k_a.ahU && Arrays.equals(this.aiS, k_a.aiS)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.aiR * 31) + Arrays.hashCode(this.aiS)) * 31) + this.ahT) * 31) + this.ahU;
    }
}
