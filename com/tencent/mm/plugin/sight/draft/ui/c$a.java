package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sight.draft.ui.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import java.lang.ref.WeakReference;

final class c$a implements Runnable {
    String aAL;
    boolean neV;
    WeakReference<c> neW;
    String path;

    private c$a() {
    }

    /* synthetic */ c$a(byte b) {
        this();
    }

    public final void run() {
        Bitmap Wb = c.Wb(this.path);
        c cVar = (c) this.neW.get();
        if (cVar != null) {
            if (!(bi.oW(this.aAL) || Wb == null)) {
                cVar.neT.put(this.aAL, Wb);
            }
            b bVar = new b((byte) 0);
            bVar.aAL = this.aAL;
            bVar.jDx = Wb;
            bVar.neW = this.neW;
            if (this.neV) {
                ah.A(bVar);
            }
        }
    }
}
