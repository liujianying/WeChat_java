package com.tencent.mm.plugin.card.d;

import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.plugin.card.d.m.1;

class m$1$1 implements Runnable {
    final /* synthetic */ Bitmap hIM;
    final /* synthetic */ 1 hIN;

    m$1$1(1 1, Bitmap bitmap) {
        this.hIN = 1;
        this.hIM = bitmap;
    }

    public final void run() {
        this.hIN.hIK.setImageBitmap(this.hIM);
        this.hIN.hIK.setColorFilter(this.hIN.fdh, Mode.SRC_IN);
    }
}
