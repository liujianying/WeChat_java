package android.support.v7.widget;

class s$a {
    long ND = 0;
    s$a NE;

    s$a() {
    }

    final void set(int i) {
        while (i >= 64) {
            this.eP();
            this = this.NE;
            i -= 64;
        }
        this.ND |= 1 << i;
    }

    private void eP() {
        if (this.NE == null) {
            this.NE = new s$a();
        }
    }

    final void clear(int i) {
        while (i >= 64) {
            if (this.NE != null) {
                this = this.NE;
                i -= 64;
            } else {
                return;
            }
        }
        this.ND &= (1 << i) ^ -1;
    }

    final boolean get(int i) {
        while (i >= 64) {
            this.eP();
            this = this.NE;
            i -= 64;
        }
        return (this.ND & (1 << i)) != 0;
    }

    final void n(int i, boolean z) {
        while (true) {
            if (i >= 64) {
                this.eP();
                this = this.NE;
                i -= 64;
            } else {
                boolean z2 = (this.ND & Long.MIN_VALUE) != 0;
                long j = (1 << i) - 1;
                this.ND = (((j ^ -1) & this.ND) << 1) | (this.ND & j);
                if (z) {
                    this.set(i);
                } else {
                    this.clear(i);
                }
                if (z2 || this.NE != null) {
                    this.eP();
                    this = this.NE;
                    i = 0;
                    z = z2;
                } else {
                    return;
                }
            }
        }
    }

    final boolean aX(int i) {
        while (i >= 64) {
            this.eP();
            this = this.NE;
            i -= 64;
        }
        long j = 1 << i;
        boolean z = (this.ND & j) != 0;
        this.ND &= j ^ -1;
        j--;
        this.ND = Long.rotateRight((j ^ -1) & this.ND, 1) | (this.ND & j);
        if (this.NE != null) {
            if (this.NE.get(0)) {
                this.set(63);
            }
            this.NE.aX(0);
        }
        return z;
    }

    final int aY(int i) {
        if (this.NE == null) {
            if (i >= 64) {
                return Long.bitCount(this.ND);
            }
            return Long.bitCount(this.ND & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.ND & ((1 << i) - 1));
        } else {
            return this.NE.aY(i - 64) + Long.bitCount(this.ND);
        }
    }

    public final String toString() {
        return this.NE == null ? Long.toBinaryString(this.ND) : this.NE.toString() + "xx" + Long.toBinaryString(this.ND);
    }
}
