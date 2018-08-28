package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class m$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ m lTE;

    m$1(m mVar, Bitmap bitmap) {
        this.lTE = mVar;
        this.abc = bitmap;
    }

    public final void run() {
        this.lTE.gxd.setImageBitmap(this.abc);
    }
}
