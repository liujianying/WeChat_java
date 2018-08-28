package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

class lm$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ lm d;

    lm$1(lm lmVar, String str, byte[] bArr, byte[] bArr2) {
        this.d = lmVar;
        this.a = str;
        this.b = bArr;
        this.c = bArr2;
    }

    public void run() {
        if (lm.a(this.d, this.a) && lm.b(this.d, this.a)) {
            ng ngVar = new ng();
            ngVar.a(this.b);
            nc ncVar = new nc(ngVar.a(), ngVar.b(), ngVar.c(), lm.a(this.d).c().a());
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.c, 0, this.c.length);
            if (decodeByteArray != null) {
                lm.b(this.d).a(jz.a(decodeByteArray, CompressFormat.PNG), ncVar);
            }
        }
    }
}
