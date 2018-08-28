package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements b<String, Bitmap> {
    final /* synthetic */ e tVi;

    e$2(e eVar) {
        this.tVi = eVar;
    }

    public final /* synthetic */ void n(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        x.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", new Object[]{(String) obj});
        if (bitmap != null && !bitmap.isRecycled() && this.tVi.jDt.indexOfKey(bitmap.hashCode()) < 0) {
            if (e.a(this.tVi).contains(Integer.valueOf(bitmap.hashCode()))) {
                e.a(this.tVi).remove(Integer.valueOf(bitmap.hashCode()));
                return;
            }
            x.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", new Object[]{bitmap.toString()});
            bitmap.recycle();
        }
    }
}
