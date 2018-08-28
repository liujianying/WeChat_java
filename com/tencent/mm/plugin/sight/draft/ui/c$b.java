package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

final class c$b implements Runnable {
    String aAL;
    Bitmap jDx;
    WeakReference<c> neW;

    private c$b() {
    }

    /* synthetic */ c$b(byte b) {
        this();
    }

    public final void run() {
        c cVar = (c) this.neW.get();
        if (cVar != null) {
            cVar.r(this.aAL, this.jDx);
        }
    }
}
