package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a;

class ProductFurtherInfoUI$a$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ a mIJ;

    ProductFurtherInfoUI$a$1(a aVar, ImageView imageView, Bitmap bitmap) {
        this.mIJ = aVar;
        this.ixr = imageView;
        this.abc = bitmap;
    }

    public final void run() {
        this.ixr.setImageBitmap(this.abc);
        this.ixr.setBackgroundColor(0);
    }
}
