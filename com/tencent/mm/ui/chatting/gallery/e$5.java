package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ int hW;
    final /* synthetic */ e tVi;

    e$5(e eVar, int i) {
        this.tVi = eVar;
        this.hW = i;
    }

    public final void run() {
        if (e.b(this.tVi) == null) {
            x.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
            return;
        }
        Bitmap FA = e.b(this.tVi).FA(this.hW);
        if (FA != null) {
            e.c(this.tVi).post(new 1(this, FA));
        }
    }
}
