package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;

class d$b {
    int Zh;
    int Zi;
    public String bKg;
    byte[] bYC;
    int bYE;
    Rect iKQ;

    public d$b(byte[] bArr, int i, int i2, int i3, Rect rect, String str) {
        this.bYC = bArr;
        this.Zh = i;
        this.Zi = i2;
        this.bYE = i3;
        this.iKQ = rect;
        this.bKg = str;
    }

    public final String toString() {
        return "RetrieveResult{yuvDataLength=" + (this.bYC != null ? Integer.valueOf(this.bYC.length) : "null") + ", previewWidth=" + this.Zh + ", previewHeight=" + this.Zi + ", rotate=" + this.bYE + ", scanRect=" + this.iKQ + ", md5=" + this.bKg + '}';
    }
}
