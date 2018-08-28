package com.google.android.exoplayer2.i;

public final class i {
    public int aCp;
    public int aCq;
    private int aCr;
    public byte[] data;

    public i(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public i(byte[] bArr, int i) {
        this.data = bArr;
        this.aCr = i;
    }

    public final void m(byte[] bArr, int i) {
        this.data = bArr;
        this.aCp = 0;
        this.aCq = 0;
        this.aCr = i;
    }

    public final int lZ() {
        return ((this.aCr - this.aCp) * 8) - this.aCq;
    }

    public final int ma() {
        a.ap(this.aCq == 0);
        return this.aCp;
    }

    public final void setPosition(int i) {
        this.aCp = i / 8;
        this.aCq = i - (this.aCp * 8);
        md();
    }

    public final void cX(int i) {
        int i2 = i / 8;
        this.aCp += i2;
        this.aCq = (i - (i2 * 8)) + this.aCq;
        if (this.aCq > 7) {
            this.aCp++;
            this.aCq -= 8;
        }
        md();
    }

    public final boolean mb() {
        boolean z;
        if ((this.data[this.aCp] & (128 >> this.aCq)) != 0) {
            z = true;
        } else {
            z = false;
        }
        int i = this.aCq + 1;
        this.aCq = i;
        if (i == 8) {
            this.aCq = 0;
            this.aCp++;
        }
        md();
        return z;
    }

    public final int cY(int i) {
        if (i == 0) {
            return 0;
        }
        this.aCq += i;
        int i2 = 0;
        while (this.aCq > 8) {
            this.aCq -= 8;
            byte[] bArr = this.data;
            int i3 = this.aCp;
            this.aCp = i3 + 1;
            i2 |= (bArr[i3] & 255) << this.aCq;
        }
        i2 = (i2 | ((this.data[this.aCp] & 255) >> (8 - this.aCq))) & (-1 >>> (32 - i));
        if (this.aCq == 8) {
            this.aCq = 0;
            this.aCp++;
        }
        md();
        return i2;
    }

    public final void mc() {
        if (this.aCq != 0) {
            this.aCq = 0;
            this.aCp++;
            md();
        }
    }

    public final void n(byte[] bArr, int i) {
        boolean z;
        if (this.aCq == 0) {
            z = true;
        } else {
            z = false;
        }
        a.ap(z);
        System.arraycopy(this.data, this.aCp, bArr, 0, i);
        this.aCp += i;
        md();
    }

    public final void md() {
        boolean z = this.aCp >= 0 && (this.aCp < this.aCr || (this.aCp == this.aCr && this.aCq == 0));
        a.ap(z);
    }
}
