package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mm.g.a.on;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends m {
    public n(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        x.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Bitmap bitmap = ((k) this.mKj).mNO;
        on onVar = new on();
        onVar.bZr.cardType = "identity";
        onVar.bZr.bZs = 1;
        if (this.mKj instanceof k) {
            onVar.bZr.bZu = bitmap;
        }
        a.sFg.a(onVar, Looper.getMainLooper());
        this.mKp.getContext().finish();
    }
}
