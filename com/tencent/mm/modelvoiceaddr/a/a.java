package com.tencent.mm.modelvoiceaddr.a;

public final class a {
    int eqX = 0;
    int eqY = 0;
    int eqZ = 0;
    short[] era;

    public a(int i) {
        if (i <= 1) {
            i = 512;
        }
        this.era = new short[i];
    }

    final int c(short[] sArr, int i) {
        int length;
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            return 0;
        }
        int length2 = this.era.length;
        if (length >= this.eqZ) {
            length = this.eqZ;
        }
        if (length <= length2 - this.eqX) {
            System.arraycopy(this.era, this.eqX, sArr, 0, length);
            this.eqX += length;
            if (this.eqX >= length2) {
                this.eqX = 0;
            }
        } else {
            length2 -= this.eqX;
            System.arraycopy(this.era, this.eqX, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.era, 0, sArr, length2, i2);
            this.eqX = i2;
        }
        this.eqZ -= length;
        return length;
    }
}
