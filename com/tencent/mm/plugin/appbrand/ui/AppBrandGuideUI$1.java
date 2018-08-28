package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AppBrandGuideUI$1 implements OnDismissListener {
    final /* synthetic */ AppBrandGuideUI guv;

    AppBrandGuideUI$1(AppBrandGuideUI appBrandGuideUI) {
        this.guv = appBrandGuideUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.guv.finish();
    }
}
