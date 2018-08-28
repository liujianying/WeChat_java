package com.tencent.tinker.a.c;

public final class b implements Cloneable {
    private static final int[] bfQ = new int[0];
    public int fi;
    public int[] tU;
    public int[] vqe;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.tU = new int[10];
        this.vqe = new int[this.tU.length];
        this.fi = 0;
    }

    private static int HQ(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private b cGT() {
        try {
            b bVar = (b) super.clone();
            try {
                bVar.tU = (int[]) this.tU.clone();
                bVar.vqe = (int[]) this.vqe.clone();
                return bVar;
            } catch (CloneNotSupportedException e) {
                return bVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void put(int i, int i2) {
        int a = a(this.tU, this.fi, i);
        if (a >= 0) {
            this.vqe[a] = i2;
            return;
        }
        a ^= -1;
        this.tU = c(this.tU, this.fi, a, i);
        this.vqe = c(this.vqe, this.fi, a, i2);
        this.fi++;
    }

    public final int indexOfKey(int i) {
        return a(this.tU, this.fi, i);
    }

    private static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ -1;
    }

    public static int[] d(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[HQ(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private static int[] c(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            Object obj = new int[HQ(i)];
            System.arraycopy(iArr, 0, obj, 0, i2);
            obj[i2] = i3;
            System.arraycopy(iArr, i2, obj, i2 + 1, iArr.length - i2);
            return obj;
        }
    }

    public final String toString() {
        if (this.fi <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.fi * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.fi; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.tU[i]);
            stringBuilder.append('=');
            stringBuilder.append(this.vqe[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
