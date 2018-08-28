package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.a.f.b;
import com.tencent.mm.plugin.gallery.model.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements b<String, a> {
    final /* synthetic */ b jAs;

    b$3(b bVar) {
        this.jAs = bVar;
    }

    public final /* synthetic */ void n(Object obj, Object obj2) {
        String str = (String) obj;
        a aVar = (a) obj2;
        if (aVar == null) {
            x.d("MicroMsg.GalleryCache", "weakReference is null");
        } else if (aVar.bitmap == null) {
            x.d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
        } else {
            aVar.bitmap.recycle();
            x.d("MicroMsg.GalleryCache", "gallery remove ", new Object[]{str});
        }
    }
}
