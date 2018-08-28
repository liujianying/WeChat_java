package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

class kw$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ kw d;

    kw$1(kw kwVar, String str, byte[] bArr, byte[] bArr2) {
        this.d = kwVar;
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
    }

    public void run() {
        if (kw.a(this.d, this.a)) {
            ng ngVar = new ng();
            ngVar.a(this.b);
            nc ncVar = new nc(ngVar.a(), ngVar.b(), ngVar.c(), "handdrawmap");
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.c, 0, this.c.length);
            if (decodeByteArray != null) {
                kw.a(this.d).a(jz.a(decodeByteArray, CompressFormat.PNG), ncVar);
            }
        }
    }
}
