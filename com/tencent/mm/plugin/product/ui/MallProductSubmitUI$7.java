package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductSubmitUI$7 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ MallProductSubmitUI lTQ;

    MallProductSubmitUI$7(MallProductSubmitUI mallProductSubmitUI, Bitmap bitmap) {
        this.lTQ = mallProductSubmitUI;
        this.abc = bitmap;
    }

    public final void run() {
        MallProductSubmitUI.e(this.lTQ).setImageBitmap(this.abc);
    }
}
