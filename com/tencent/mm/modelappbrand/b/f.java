package com.tencent.mm.modelappbrand.b;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.c;

public final class f implements com.tencent.mm.modelappbrand.b.b.f {
    public static final f dGr = new f();

    public final Bitmap o(Bitmap bitmap) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return bitmap;
        }
        return c.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
    }

    public final String Ke() {
        return "WxaIcon";
    }
}
