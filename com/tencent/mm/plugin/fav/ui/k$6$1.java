package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.fav.ui.k.6;

class k$6$1 implements Runnable {
    final /* synthetic */ Bitmap jaX;
    final /* synthetic */ 6 jaY;

    k$6$1(6 6, Bitmap bitmap) {
        this.jaY = 6;
        this.jaX = bitmap;
    }

    public final void run() {
        this.jaY.ixr.setImageBitmap(this.jaX);
    }
}
