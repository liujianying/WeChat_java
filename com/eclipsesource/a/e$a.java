package com.eclipsesource.a;

import com.tencent.smtt.sdk.WebView;

class e$a {
    final byte[] abK = new byte[32];

    final void h(String str, int i) {
        int U = U(str);
        if (i < WebView.NORMAL_MODE_ALPHA) {
            this.abK[U] = (byte) (i + 1);
        } else {
            this.abK[U] = (byte) 0;
        }
    }

    public final void remove(int i) {
        for (int i2 = 0; i2 < this.abK.length; i2++) {
            if (this.abK[i2] == i + 1) {
                this.abK[i2] = (byte) 0;
            } else if (this.abK[i2] > i + 1) {
                byte[] bArr = this.abK;
                bArr[i2] = (byte) (bArr[i2] - 1);
            }
        }
    }

    final int U(Object obj) {
        return obj.hashCode() & (this.abK.length - 1);
    }
}
