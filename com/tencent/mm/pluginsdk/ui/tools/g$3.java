package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.tools.g.c;
import com.tencent.mm.sdk.platformtools.x;

class g$3 extends c<String, Bitmap> {
    final /* synthetic */ g qSF;

    g$3(g gVar, int i) {
        this.qSF = gVar;
        super(gVar, i);
    }

    protected final /* synthetic */ void ca(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            x.i("MicroMsg.ImageEngine", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
