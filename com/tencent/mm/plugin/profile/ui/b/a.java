package com.tencent.mm.plugin.profile.ui.b;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.y.a {
    private String url;

    public a(Resources resources, String str) {
        boolean z = true;
        Bitmap e = com.tencent.mm.model.am.a.dBt != null ? b.e(com.tencent.mm.model.am.a.dBt.gX(16), 2.0f) : null;
        String str2 = "MicroMsg.UrlDrawable";
        String str3 = "verify bmp is null ? %B";
        Object[] objArr = new Object[1];
        if (e != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        super(resources, e);
        this.url = str;
        y.a(this);
    }

    public final void draw(Canvas canvas) {
        Bitmap a = y.a(new 1(this));
        if (a == null || a.isRecycled()) {
            a = null;
        }
        Rect bounds = getBounds();
        if (a != null) {
            canvas.drawBitmap(a, null, bounds, null);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (this.url.equals(str)) {
            invalidateSelf();
        }
    }
}
