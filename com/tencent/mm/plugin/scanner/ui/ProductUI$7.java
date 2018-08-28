package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;

class ProductUI$7 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String lMy;
    final /* synthetic */ ProductUI mJt;

    ProductUI$7(ProductUI productUI, String str, Bitmap bitmap) {
        this.mJt = productUI;
        this.lMy = str;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.lMy.equals(ProductUI.a(this.mJt).field_thumburl) && ProductUI.q(this.mJt) != null) {
            x.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + this.lMy);
            try {
                ProductUI.q(this.mJt).setImageBitmap(this.abc);
                ProductUI.q(this.mJt).setBackgroundDrawable(null);
                ProductUI.q(this.mJt).setBackgroundColor(-1);
                ProductUI.r(this.mJt);
                ProductUI.s(this.mJt);
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
            }
        }
        if (this.lMy.equals(ProductUI.a(this.mJt).field_headerbackgroundurl) && ProductUI.t(this.mJt) != null) {
            ProductUI.t(this.mJt).setImageBitmap(this.abc);
        }
    }
}
