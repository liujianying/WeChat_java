package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class h$c implements b {
    final WeakReference<h> jEN;

    h$c(h hVar) {
        this.jEN = new WeakReference(hVar);
    }

    public final void CR(String str) {
        h hVar = (h) this.jEN.get();
        if (hVar == null) {
            x.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this event.");
        } else if (bi.oW(str)) {
            x.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
        } else if (hVar.mFilePath.equals(str)) {
            x.d("MicroMsg.ThumbDrawable", "notify thumb get " + str);
            hVar.isa.post(new h.b(hVar));
        } else {
            x.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", new Object[]{str});
        }
    }
}
