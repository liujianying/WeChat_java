package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] lEV;
    private transient int lEW;
    private transient int lEX;
    private transient int lEY;

    public a(byte[] bArr) {
        this.lEV = (byte[]) bArr.clone();
        bjo();
    }

    public a(String str) {
        this.lEV = com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str);
        bjo();
    }

    private void bjo() {
        int i = 65536;
        int i2 = 256;
        if (this.lEV.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (this.lEV.length != 4) {
            int i3 = this.lEV[4] & 255;
            if (this.lEV.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.lEX = i2;
            } else if (i3 != 0) {
                if (this.lEV.length == i3 + 5) {
                    this.lEW = i3;
                    this.lEY = 5;
                } else if (this.lEV.length == i3 + 6) {
                    this.lEW = i3;
                    this.lEY = 5;
                    i3 = this.lEV[this.lEV.length - 1] & 255;
                    if (i3 != 0) {
                        i2 = i3;
                    }
                    this.lEX = i2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.lEV.length + ", b1=" + i3);
                }
            } else if (this.lEV.length < 7) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.lEV.length + ", b1=" + i3);
            } else {
                i2 = ((this.lEV[5] & 255) << 8) | (this.lEV[6] & 255);
                if (this.lEV.length == 7) {
                    if (i2 == 0) {
                        i2 = 65536;
                    }
                    this.lEX = i2;
                } else if (i2 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.lEV.length + ", b1=" + i3 + ", b2||b3=" + i2);
                } else if (this.lEV.length == i2 + 7) {
                    this.lEW = i2;
                    this.lEY = 7;
                } else if (this.lEV.length == i2 + 9) {
                    this.lEW = i2;
                    this.lEY = 7;
                    i2 = this.lEV.length - 2;
                    i2 = (this.lEV[i2 + 1] & 255) | ((this.lEV[i2] & 255) << 8);
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.lEX = i;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.lEV.length + ", b1=" + i3 + ", b2||b3=" + i2);
                }
            }
        }
    }

    public final void tX(int i) {
        this.lEX = i;
        this.lEV[this.lEV.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        return (byte[]) this.lEV.clone();
    }

    public final String toString() {
        return com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(this.lEV);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(this.lEV, ((a) obj).lEV);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.lEV);
    }
}
