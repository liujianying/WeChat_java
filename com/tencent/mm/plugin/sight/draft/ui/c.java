package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> neT = new f(24);
    private Bitmap neU;

    public abstract void r(String str, Bitmap bitmap);

    public final Bitmap o(String str, String str2, boolean z) {
        if (bi.oW(str)) {
            return bwg();
        }
        Bitmap bitmap = (Bitmap) this.neT.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        a aVar = new a((byte) 0);
        aVar.aAL = str;
        aVar.path = str2;
        aVar.neV = z;
        aVar.neW = new WeakReference(this);
        if (z) {
            au.Em().H(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.neT.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return bwg();
    }

    private Bitmap bwg() {
        if (this.neU == null) {
            this.neU = com.tencent.mm.sdk.platformtools.c.CV(R.k.panel_icon_pic);
        }
        return this.neU;
    }
}
