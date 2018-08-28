package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h.d;

class ProductFurtherInfoUI$2$1 implements d {
    final /* synthetic */ 2 mIF;

    ProductFurtherInfoUI$2$1(2 2) {
        this.mIF = 2;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case 0:
                if (!bi.oW(ProductFurtherInfoUI.a(this.mIF.mIE))) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ProductFurtherInfoUI.a(this.mIF.mIE));
                    com.tencent.mm.bg.d.b(this.mIF.mIE.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
