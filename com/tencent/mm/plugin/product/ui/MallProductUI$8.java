package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductUI$8 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ MallProductUI lUa;

    MallProductUI$8(MallProductUI mallProductUI, Bitmap bitmap) {
        this.lUa = mallProductUI;
        this.abc = bitmap;
    }

    public final void run() {
        MallProductUI.g(this.lUa).setImageBitmap(this.abc);
    }
}
