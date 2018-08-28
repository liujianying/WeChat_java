package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductSelectSkuUI$5 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ MallProductSelectSkuUI lTq;

    MallProductSelectSkuUI$5(MallProductSelectSkuUI mallProductSelectSkuUI, Bitmap bitmap) {
        this.lTq = mallProductSelectSkuUI;
        this.abc = bitmap;
    }

    public final void run() {
        MallProductSelectSkuUI.e(this.lTq).setImageBitmap(this.abc);
    }
}
