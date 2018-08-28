package com.tencent.tinker.a.c;

public final class a implements Cloneable {
    private static final int[] bfQ = new int[0];
    private static final boolean[] vqc = new boolean[0];
    private int fi;
    private int[] tU;
    private boolean[] vqd;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.tU = new int[10];
        this.vqd = new boolean[10];
        this.fi = 0;
    }

    private static int HQ(int i) {
        return i <= 4 ? 8 : (i >> 1) + i;
    }

    private a cGS() {
        try {
            a aVar = (a) super.clone();
            try {
                aVar.tU = (int[]) this.tU.clone();
                aVar.vqd = (boolean[]) this.vqd.clone();
                return aVar;
            } catch (CloneNotSupportedException e) {
                return aVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final void HR(int i) {
        int a = a(this.tU, this.fi, i);
        if (a >= 0) {
            this.vqd[a] = true;
            return;
        }
        int i2 = a ^ -1;
        int[] iArr = this.tU;
        int i3 = this.fi;
        if (i3 > iArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i3);
        }
        Object obj;
        Object iArr2;
        if (i3 + 1 <= iArr2.length) {
            System.arraycopy(iArr2, i2, iArr2, i2 + 1, i3 - i2);
            iArr2[i2] = i;
        } else {
            obj = new int[HQ(i3)];
            System.arraycopy(iArr2, 0, obj, 0, i2);
            obj[i2] = i;
            System.arraycopy(iArr2, i2, obj, i2 + 1, iArr2.length - i2);
            iArr2 = obj;
        }
        this.tU = iArr2;
        boolean[] zArr = this.vqd;
        i3 = this.fi;
        if (i3 > zArr.length) {
            throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i3);
        }
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
            zArr[i2] = true;
        } else {
            obj = new boolean[HQ(i3)];
            System.arraycopy(zArr, 0, obj, 0, i2);
            obj[i2] = 1;
            System.arraycopy(zArr, i2, obj, i2 + 1, zArr.length - i2);
            iArr2 = obj;
        }
        this.vqd = zArr;
        this.fi++;
    }

    public final boolean HS(int i) {
        return a(this.tU, this.fi, i) >= 0;
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
            stringBuilder.append(this.vqd[i]);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
