package com.google.android.gms.c;

final class ba implements Cloneable {
    static final bb bab = new bb();
    boolean bac;
    int[] bad;
    bb[] bae;
    int fi;

    public ba() {
        this(10);
    }

    private ba(int i) {
        this.bac = false;
        int ad = ad(i);
        this.bad = new int[ad];
        this.bae = new bb[ad];
        this.fi = 0;
    }

    static int ad(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public final bb dM(int i) {
        if (this.bac) {
            gc();
        }
        return this.bae[i];
    }

    final int dN(int i) {
        int i2 = 0;
        int i3 = this.fi - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bad[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (size() != baVar.size()) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.bad;
        int[] iArr2 = baVar.bad;
        int i2 = this.fi;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            bb[] bbVarArr = this.bae;
            bb[] bbVarArr2 = baVar.bae;
            i2 = this.fi;
            for (i = 0; i < i2; i++) {
                if (!bbVarArr[i].equals(bbVarArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    final void gc() {
        int i = this.fi;
        int[] iArr = this.bad;
        bb[] bbVarArr = this.bae;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            bb bbVar = bbVarArr[i3];
            if (bbVar != bab) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    bbVarArr[i2] = bbVar;
                    bbVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.bac = false;
        this.fi = i2;
    }

    public final int hashCode() {
        if (this.bac) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.fi; i2++) {
            i = (((i * 31) + this.bad[i2]) * 31) + this.bae[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    /* renamed from: qI */
    public final ba clone() {
        int i = 0;
        int size = size();
        ba baVar = new ba(size);
        System.arraycopy(this.bad, 0, baVar.bad, 0, size);
        while (i < size) {
            if (this.bae[i] != null) {
                baVar.bae[i] = this.bae[i].clone();
            }
            i++;
        }
        baVar.fi = size;
        return baVar;
    }

    public final int size() {
        if (this.bac) {
            gc();
        }
        return this.fi;
    }
}
