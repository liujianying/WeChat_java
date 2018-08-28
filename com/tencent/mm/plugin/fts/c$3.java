package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.fts.c.c;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements c {
    final /* synthetic */ c joV;
    final /* synthetic */ ImageView joW;
    final /* synthetic */ Context val$context;

    c$3(c cVar, ImageView imageView, Context context) {
        this.joV = cVar;
        this.joW = imageView;
        this.val$context = context;
    }

    public final void au(String str, boolean z) {
        x.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", new Object[]{str, Boolean.valueOf(z)});
        c.b(this.joV).remove(str);
        if (z) {
            Bitmap a = c.a(this.joV, str);
            if (str.equals(this.joW.getTag())) {
                c.c(this.joV).post(new 1(this, str, a));
            }
        }
    }
}
