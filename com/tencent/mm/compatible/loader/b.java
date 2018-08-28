package com.tencent.mm.compatible.loader;

public final class b<E> {
    static final Object tA = new Object();
    int fi;
    boolean tB;
    long[] tC;
    Object[] tD;

    public final void put(long j, E e) {
        int b = b(this.tC, this.fi, j);
        if (b >= 0) {
            this.tD[b] = e;
            return;
        }
        b ^= -1;
        if (b >= this.fi || this.tD[b] != tA) {
            int i;
            if (this.tB && this.fi >= this.tC.length) {
                int i2 = this.fi;
                long[] jArr = this.tC;
                Object[] objArr = this.tD;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr[i];
                    if (obj != tA) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr[b] = obj;
                        }
                        b++;
                    }
                }
                this.tB = false;
                this.fi = b;
                b = b(this.tC, this.fi, j) ^ -1;
            }
            if (this.fi >= this.tC.length) {
                i = a.ad(this.fi + 1);
                Object obj2 = new long[i];
                Object obj3 = new Object[i];
                System.arraycopy(this.tC, 0, obj2, 0, this.tC.length);
                System.arraycopy(this.tD, 0, obj3, 0, this.tD.length);
                this.tC = obj2;
                this.tD = obj3;
            }
            if (this.fi - b != 0) {
                System.arraycopy(this.tC, b, this.tC, b + 1, this.fi - b);
                System.arraycopy(this.tD, b, this.tD, b + 1, this.fi - b);
            }
            this.tC[b] = j;
            this.tD[b] = e;
            this.fi++;
            return;
        }
        this.tC[b] = j;
        this.tD[b] = e;
    }

    static int b(long[] jArr, int i, long j) {
        int i2 = i + 0;
        int i3 = -1;
        while (i2 - i3 > 1) {
            int i4 = (i2 + i3) / 2;
            if (jArr[i4] < j) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
        if (i2 == i + 0) {
            return (i + 0) ^ -1;
        }
        return jArr[i2] != j ? i2 ^ -1 : i2;
    }
}
