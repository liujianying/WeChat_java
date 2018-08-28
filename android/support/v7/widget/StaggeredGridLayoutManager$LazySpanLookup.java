package android.support.v7.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StaggeredGridLayoutManager$LazySpanLookup {
    List<FullSpanItem> Vg;
    int[] mData;

    final int bG(int i) {
        if (this.Vg != null) {
            for (int size = this.Vg.size() - 1; size >= 0; size--) {
                if (((FullSpanItem) this.Vg.get(size)).mPosition >= i) {
                    this.Vg.remove(size);
                }
            }
        }
        return bH(i);
    }

    final int bH(int i) {
        if (this.mData == null) {
            return -1;
        }
        if (i >= this.mData.length) {
            return -1;
        }
        int i2;
        if (this.Vg != null) {
            FullSpanItem bJ = bJ(i);
            if (bJ != null) {
                this.Vg.remove(bJ);
            }
            int size = this.Vg.size();
            int i3 = 0;
            while (i3 < size) {
                if (((FullSpanItem) this.Vg.get(i3)).mPosition >= i) {
                    break;
                }
                i3++;
            }
            i3 = -1;
            if (i3 != -1) {
                bJ = (FullSpanItem) this.Vg.get(i3);
                this.Vg.remove(i3);
                i2 = bJ.mPosition;
                if (i2 != -1) {
                    Arrays.fill(this.mData, i, this.mData.length, -1);
                    return this.mData.length;
                }
                Arrays.fill(this.mData, i, i2 + 1, -1);
                return i2 + 1;
            }
        }
        i2 = -1;
        if (i2 != -1) {
            Arrays.fill(this.mData, i, i2 + 1, -1);
            return i2 + 1;
        }
        Arrays.fill(this.mData, i, this.mData.length, -1);
        return this.mData.length;
    }

    final void bI(int i) {
        if (this.mData == null) {
            this.mData = new int[(Math.max(i, 10) + 1)];
            Arrays.fill(this.mData, -1);
        } else if (i >= this.mData.length) {
            Object obj = this.mData;
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            this.mData = new int[length];
            System.arraycopy(obj, 0, this.mData, 0, obj.length);
            Arrays.fill(this.mData, obj.length, this.mData.length, -1);
        }
    }

    final void clear() {
        if (this.mData != null) {
            Arrays.fill(this.mData, -1);
        }
        this.Vg = null;
    }

    final void al(int i, int i2) {
        if (this.mData != null && i < this.mData.length) {
            bI(i + i2);
            System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
            Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
            if (this.Vg != null) {
                int i3 = i + i2;
                for (int size = this.Vg.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.Vg.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.Vg.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }
    }

    final void am(int i, int i2) {
        if (this.mData != null && i < this.mData.length) {
            bI(i + i2);
            System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
            Arrays.fill(this.mData, i, i + i2, -1);
            if (this.Vg != null) {
                for (int size = this.Vg.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.Vg.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }
    }

    public final void a(FullSpanItem fullSpanItem) {
        if (this.Vg == null) {
            this.Vg = new ArrayList();
        }
        int size = this.Vg.size();
        for (int i = 0; i < size; i++) {
            FullSpanItem fullSpanItem2 = (FullSpanItem) this.Vg.get(i);
            if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                this.Vg.remove(i);
            }
            if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                this.Vg.add(i, fullSpanItem);
                return;
            }
        }
        this.Vg.add(fullSpanItem);
    }

    public final FullSpanItem bJ(int i) {
        if (this.Vg == null) {
            return null;
        }
        for (int size = this.Vg.size() - 1; size >= 0; size--) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.Vg.get(size);
            if (fullSpanItem.mPosition == i) {
                return fullSpanItem;
            }
        }
        return null;
    }

    public final FullSpanItem q(int i, int i2, int i3) {
        if (this.Vg == null) {
            return null;
        }
        int size = this.Vg.size();
        for (int i4 = 0; i4 < size; i4++) {
            FullSpanItem fullSpanItem = (FullSpanItem) this.Vg.get(i4);
            if (fullSpanItem.mPosition >= i2) {
                return null;
            }
            if (fullSpanItem.mPosition >= i && (i3 == 0 || fullSpanItem.Vh == i3 || fullSpanItem.Vj)) {
                return fullSpanItem;
            }
        }
        return null;
    }
}
