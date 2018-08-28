package com.tencent.mm.modelappbrand.b;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.modelappbrand.b.b.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public final class b$c implements i {
    final f<String, Reference<Bitmap>> dFY = new 1(this);

    public final Bitmap jz(String str) {
        if (bi.oW(str)) {
            return null;
        }
        Reference reference = (Reference) this.dFY.get(str);
        if (reference == null) {
            return null;
        }
        Bitmap bitmap = (Bitmap) reference.get();
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        this.dFY.remove(str);
        return null;
    }

    public final void d(String str, Bitmap bitmap) {
        if (!bi.oW(str) && bitmap != null) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", new Object[]{str, bitmap});
            this.dFY.put(str, new SoftReference(bitmap));
        }
    }

    public final void k(Bitmap bitmap) {
        x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", new Object[]{bitmap});
        if (bitmap != null) {
            bitmap.isRecycled();
        }
    }
}
