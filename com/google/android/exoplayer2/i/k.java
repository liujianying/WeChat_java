package com.google.android.exoplayer2.i;

public final class k {
    private int aCp;
    private int aCq;
    private int aCr;
    private byte[] data;

    public k(byte[] bArr, int i, int i2) {
        k(bArr, i, i2);
    }

    public final void k(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.aCp = i;
        this.aCr = i2;
        this.aCq = 0;
        md();
    }

    public final void mk() {
        int i = this.aCq + 1;
        this.aCq = i;
        if (i == 8) {
            this.aCq = 0;
            this.aCp = (dc(this.aCp + 1) ? 2 : 1) + this.aCp;
        }
        md();
    }

    public final void cX(int i) {
        int i2 = this.aCp;
        int i3 = i / 8;
        this.aCp += i3;
        this.aCq = (i - (i3 * 8)) + this.aCq;
        if (this.aCq > 7) {
            this.aCp++;
            this.aCq -= 8;
        }
        while (true) {
            i2++;
            if (i2 > this.aCp) {
                md();
                return;
            } else if (dc(i2)) {
                this.aCp++;
                i2 += 2;
            }
        }
    }

    public final boolean db(int i) {
        int i2 = this.aCp;
        int i3 = i / 8;
        int i4 = this.aCp + i3;
        i3 = (this.aCq + i) - (i3 * 8);
        if (i3 > 7) {
            i4++;
            i3 -= 8;
        }
        i2++;
        while (i2 <= i4 && i4 < this.aCr) {
            if (dc(i2)) {
                i4++;
                i2 += 2;
            }
            i2++;
        }
        return i4 < this.aCr || (i4 == this.aCr && i3 == 0);
    }

    public final boolean mb() {
        boolean z = (this.data[this.aCp] & (128 >> this.aCq)) != 0;
        mk();
        return z;
    }

    public final int cY(int i) {
        int i2 = 2;
        this.aCq += i;
        int i3 = 0;
        while (this.aCq > 8) {
            this.aCq -= 8;
            i3 |= (this.data[this.aCp] & 255) << this.aCq;
            this.aCp = (dc(this.aCp + 1) ? 2 : 1) + this.aCp;
        }
        i3 = (i3 | ((this.data[this.aCp] & 255) >> (8 - this.aCq))) & (-1 >>> (32 - i));
        if (this.aCq == 8) {
            this.aCq = 0;
            int i4 = this.aCp;
            if (!dc(this.aCp + 1)) {
                i2 = 1;
            }
            this.aCp = i4 + i2;
        }
        md();
        return i3;
    }

    public final boolean ml() {
        boolean z;
        int i = this.aCp;
        int i2 = this.aCq;
        int i3 = 0;
        while (this.aCp < this.aCr && !mb()) {
            i3++;
        }
        if (this.aCp == this.aCr) {
            z = true;
        } else {
            z = false;
        }
        this.aCp = i;
        this.aCq = i2;
        if (z || !db((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public final int mm() {
        int mn = mn();
        return (mn % 2 == 0 ? -1 : 1) * ((mn + 1) / 2);
    }

    public final int mn() {
        int i = 0;
        int i2 = 0;
        while (!mb()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = cY(i2);
        }
        return i3 + i;
    }

    private boolean dc(int i) {
        return 2 <= i && i < this.aCr && this.data[i] == (byte) 3 && this.data[i - 2] == (byte) 0 && this.data[i - 1] == (byte) 0;
    }

    private void md() {
        boolean z = this.aCp >= 0 && (this.aCp < this.aCr || (this.aCp == this.aCr && this.aCq == 0));
        a.ap(z);
    }
}
