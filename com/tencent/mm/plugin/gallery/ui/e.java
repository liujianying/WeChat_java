package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;

final class e {
    private c jDA;
    int jDz = -1;

    public e(c cVar) {
        this.jDA = cVar;
    }

    final void qG(int i) {
        c cVar = this.jDA;
        if (cVar.jBz != null && cVar.jBz.size() > i && i >= 0) {
            long j = ((MediaItem) cVar.jBz.get(i)).jAU;
            String str = ((MediaItem) cVar.jBz.get(i)).iSr;
            String str2 = ((MediaItem) cVar.jBz.get(i)).egA;
            if (bi.oW(str)) {
                str = str2;
            }
            c.aRe().b(str, ((MediaItem) cVar.jBz.get(i)).getType(), str2, j);
        }
    }
}
