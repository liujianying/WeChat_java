package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

final class n {
    private boolean anx;
    public int aoA;
    private final int aox;
    boolean aoy;
    public byte[] aoz = new byte[131];

    public n(int i) {
        this.aox = i;
        this.aoz[2] = (byte) 1;
    }

    public final void reset() {
        this.anx = false;
        this.aoy = false;
    }

    public final void cB(int i) {
        boolean z = true;
        a.ap(!this.anx);
        if (i != this.aox) {
            z = false;
        }
        this.anx = z;
        if (this.anx) {
            this.aoA = 3;
            this.aoy = false;
        }
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.anx) {
            int i3 = i2 - i;
            if (this.aoz.length < this.aoA + i3) {
                this.aoz = Arrays.copyOf(this.aoz, (this.aoA + i3) * 2);
            }
            System.arraycopy(bArr, i, this.aoz, this.aoA, i3);
            this.aoA = i3 + this.aoA;
        }
    }

    public final boolean cC(int i) {
        if (!this.anx) {
            return false;
        }
        this.aoA -= i;
        this.anx = false;
        this.aoy = true;
        return true;
    }
}
