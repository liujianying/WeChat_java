package com.tencent.mm.bq;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.g.a.a;

public class c$a implements a {
    com.tencent.mm.svg.a.a sCI = new com.tencent.mm.svg.a.a();

    public final Bitmap decodeResource(Resources resources, int i, Options options) {
        if (!this.sCI.d(resources, i)) {
            return null;
        }
        float f = 0.0f;
        if (options != null) {
            f = ((float) options.inDensity) / 160.0f;
        }
        return com.tencent.mm.svg.a.a.b(resources, i, f);
    }
}
