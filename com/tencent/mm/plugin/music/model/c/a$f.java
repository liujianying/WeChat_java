package com.tencent.mm.plugin.music.model.c;

import com.tencent.mm.sdk.platformtools.x;

class a$f {
    int[] lyZ;

    private a$f() {
        this.lyZ = new int[]{1, 1, 1, 1};
    }

    /* synthetic */ a$f(byte b) {
        this();
    }

    final void p(boolean z, int i) {
        int q = q(z, i);
        x.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i + "], lastState=" + this.lyZ[3] + ",newState=" + q);
        if (this.lyZ[3] != q) {
            this.lyZ[0] = this.lyZ[1];
            this.lyZ[1] = this.lyZ[2];
            this.lyZ[2] = this.lyZ[3];
            this.lyZ[3] = q;
            x.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.lyZ[0] + "," + this.lyZ[1] + "," + this.lyZ[2] + "," + this.lyZ[3] + "]");
        }
    }

    static int q(boolean z, int i) {
        return (z ? -268435456 : 0) | i;
    }

    final boolean b(int[] iArr, boolean z) {
        int i = z ? 268435455 : -1;
        int length = this.lyZ.length - iArr.length;
        boolean z2 = true;
        for (int i2 = length; i2 < this.lyZ.length; i2++) {
            z2 &= (this.lyZ[i2] & i) == (iArr[i2 - length] & i) ? 1 : 0;
        }
        return z2;
    }
}
