package com.tencent.mm.plugin.appbrand.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.b.b$f;
import com.tencent.mm.sdk.platformtools.c;

public final class a implements b$f {
    private final int gzI;
    private final int gzK;
    private final int gzL = -1;

    public a(int i, int i2) {
        this.gzI = i;
        this.gzK = i2;
    }

    public final Bitmap o(Bitmap bitmap) {
        Bitmap a = c.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.gzI, this.gzI, false);
        if (a != createScaledBitmap) {
            l.Fu().l(a);
        }
        a = Bitmap.createBitmap(this.gzI + (this.gzK * 2), this.gzI + (this.gzK * 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(a);
        canvas.drawBitmap(createScaledBitmap, (float) this.gzK, (float) this.gzK, new Paint());
        l.Fu().l(createScaledBitmap);
        Paint paint = new Paint();
        paint.setColor(this.gzL);
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) this.gzK);
        canvas.drawCircle((float) ((this.gzI / 2) + this.gzK), (float) ((this.gzI / 2) + this.gzK), (float) (this.gzI / 2), paint);
        return a;
    }

    public final String Ke() {
        return "WxaNearbyShowcaseIcon";
    }
}
