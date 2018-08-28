package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.game.e.e.2;

class e$2$1 implements Runnable {
    final /* synthetic */ Bitmap kdt;
    final /* synthetic */ 2 kdu;

    e$2$1(2 2, Bitmap bitmap) {
        this.kdu = 2;
        this.kdt = bitmap;
    }

    public final void run() {
        if (this.kdu.joW != null) {
            this.kdu.joW.setImageBitmap(this.kdt);
        }
    }
}
