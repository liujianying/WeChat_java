package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements b<Integer, Bitmap> {
    final /* synthetic */ e tVi;

    e$1(e eVar) {
        this.tVi = eVar;
    }

    public final /* synthetic */ void n(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
