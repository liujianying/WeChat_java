package com.tencent.mm.plugin.gallery.ui;

import android.os.SystemClock;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

final class h$b implements Runnable {
    final WeakReference<h> jEN;

    h$b(h hVar) {
        this.jEN = new WeakReference(hVar);
    }

    public final void run() {
        h hVar = (h) this.jEN.get();
        if (hVar == null) {
            x.w("MicroMsg.ThumbDrawable", "[tomys] owner is recycled, ignore this task.");
            return;
        }
        x.v("MicroMsg.ThumbDrawable", "invalidateSelf");
        a aRe = c.aRe();
        String str = hVar.mFilePath;
        String str2 = hVar.jAm;
        long j = hVar.jAn;
        h.a(hVar, aRe.CQ(str));
        if (!(hVar.jEJ == null || h.a(hVar) == null || h.a(hVar).isRecycled())) {
            hVar.jEJ.aRO();
        }
        hVar.jEK = SystemClock.uptimeMillis();
        hVar.invalidateSelf();
    }
}
