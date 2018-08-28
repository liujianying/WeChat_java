package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppBrandIDCardUI$3 implements OnCancelListener {
    final /* synthetic */ AppBrandIDCardUI gxB;

    AppBrandIDCardUI$3(AppBrandIDCardUI appBrandIDCardUI) {
        this.gxB = appBrandIDCardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.gxB.setResult(0);
        this.gxB.finish();
    }
}
