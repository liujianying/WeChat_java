package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements b<String, Bitmap> {
    final /* synthetic */ g dUE;

    g$1(g gVar) {
        this.dUE = gVar;
    }

    public final /* synthetic */ void n(Object obj, Object obj2) {
        String str = (String) obj;
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.ImgInfoStorage", "[preRemoveCallback] key:%s bitmap:%s", new Object[]{str, bitmap.toString()});
            bitmap.recycle();
        }
    }
}
