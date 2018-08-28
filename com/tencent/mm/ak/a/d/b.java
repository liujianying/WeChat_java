package com.tencent.mm.ak.a.d;

import android.graphics.Bitmap;

public final class b {
    public String aBC;
    public int bJu;
    public Bitmap bitmap;
    public byte[] data;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.bJu = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.aBC = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.bJu = 2;
        this.aBC = str;
    }
}
