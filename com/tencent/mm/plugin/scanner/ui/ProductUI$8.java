package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.d;
import com.tencent.mm.sdk.platformtools.x;

class ProductUI$8 implements OnCancelListener {
    final /* synthetic */ ProductUI mJt;
    final /* synthetic */ d mJw;

    ProductUI$8(ProductUI productUI, d dVar) {
        this.mJt = productUI;
        this.mJw = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.scanner.ProductUI", "User cancel");
        au.DF().c(this.mJw);
    }
}
