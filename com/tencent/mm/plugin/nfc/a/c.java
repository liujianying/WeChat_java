package com.tencent.mm.plugin.nfc.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.nfc.d.a;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] lEV;

    public c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("apdu is null");
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        if (bArr2.length < 2) {
            throw new IllegalArgumentException("apdu must be at least 2 bytes long");
        }
        this.lEV = bArr2;
    }

    public final short bjp() {
        return (short) (this.lEV[this.lEV.length - 2] & b.CTRL_BYTE);
    }

    public final short bjq() {
        return (short) (this.lEV[this.lEV.length - 1] & b.CTRL_BYTE);
    }

    public final String toString() {
        return a.byteArrayToHexString(this.lEV);
    }

    public final void a(c cVar) {
        int length = this.lEV.length;
        this.lEV = Arrays.copyOf(this.lEV, (this.lEV.length + cVar.lEV.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) cVar.lEV.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.lEV[i] = bArr[i2];
            i2++;
            i = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.lEV, ((c) obj).lEV);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.lEV);
    }
}
