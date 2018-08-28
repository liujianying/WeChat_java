package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$b {
    final SparseIntArray OE = new SparseIntArray();
    private boolean OF = false;

    public abstract int bc(int i);

    final int K(int i, int i2) {
        if (!this.OF) {
            return J(i, i2);
        }
        int i3 = this.OE.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = J(i, i2);
        this.OE.put(i, i3);
        return i3;
    }

    public int J(int i, int i2) {
        int bc = bc(i);
        if (bc == i2) {
            return 0;
        }
        int size;
        int i3;
        int i4;
        if (this.OF && this.OE.size() > 0) {
            size = this.OE.size() - 1;
            i3 = 0;
            while (i3 <= size) {
                i4 = (i3 + size) >>> 1;
                if (this.OE.keyAt(i4) < i) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            size = i3 - 1;
            size = (size < 0 || size >= this.OE.size()) ? -1 : this.OE.keyAt(size);
            if (size >= 0) {
                i3 = this.OE.get(size) + bc(size);
                size++;
                i4 = size;
                while (i4 < i) {
                    size = bc(i4);
                    i3 += size;
                    if (i3 == i2) {
                        size = 0;
                    } else if (i3 <= i2) {
                        size = i3;
                    }
                    i4++;
                    i3 = size;
                }
                if (i3 + bc > i2) {
                    return i3;
                }
                return 0;
            }
        }
        size = 0;
        i3 = 0;
        i4 = size;
        while (i4 < i) {
            size = bc(i4);
            i3 += size;
            if (i3 == i2) {
                size = 0;
            } else if (i3 <= i2) {
                size = i3;
            }
            i4++;
            i3 = size;
        }
        if (i3 + bc > i2) {
            return 0;
        }
        return i3;
    }

    public final int L(int i, int i2) {
        int bc = bc(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int bc2 = bc(i3);
            int i6 = i5 + bc2;
            if (i6 == i2) {
                i4++;
                bc2 = 0;
            } else if (i6 > i2) {
                i4++;
            } else {
                bc2 = i6;
            }
            i3++;
            i5 = bc2;
        }
        if (i5 + bc > i2) {
            return i4 + 1;
        }
        return i4;
    }
}
