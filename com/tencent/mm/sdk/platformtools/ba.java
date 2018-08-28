package com.tencent.mm.sdk.platformtools;

public class ba<T> {
    public Object[] tM;
    public int tN;

    public ba(int i) {
        if (i <= 0) {
            x.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
        } else {
            this.tM = new Object[i];
        }
    }

    public T bW() {
        if (this.tM == null || this.tN <= 0) {
            return null;
        }
        int i = this.tN - 1;
        T t = this.tM[i];
        this.tM[i] = null;
        this.tN--;
        return t;
    }

    public boolean j(T t) {
        if (this.tM == null) {
            return false;
        }
        int i;
        if (this.tM != null) {
            for (i = 0; i < this.tN; i++) {
                if (this.tM[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            return false;
        }
        if (this.tN >= this.tM.length || this.tN < 0) {
            x.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[]{Integer.valueOf(this.tN), Integer.valueOf(this.tM.length)});
            return false;
        }
        this.tM[this.tN] = t;
        this.tN++;
        return true;
    }
}
