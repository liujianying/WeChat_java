package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class ProductUI$14 implements OnClickListener {
    final /* synthetic */ ProductUI mJt;

    ProductUI$14(ProductUI productUI) {
        this.mJt = productUI;
    }

    public final void onClick(View view) {
        if (ProductUI.a(this.mJt) != null && !bi.oW(ProductUI.a(this.mJt).field_certificationurl)) {
            ProductUI.a(this.mJt, 10002, ProductUI.a(this.mJt).field_certificationurl);
            ProductUI.a(this.mJt, ProductUI.a(this.mJt).field_certificationurl);
        }
    }
}
