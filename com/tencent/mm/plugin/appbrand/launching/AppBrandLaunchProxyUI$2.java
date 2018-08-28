package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AppBrandLaunchProxyUI$2 implements OnDismissListener {
    final /* synthetic */ AppBrandLaunchProxyUI geK;

    AppBrandLaunchProxyUI$2(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        this.geK = appBrandLaunchProxyUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (!this.geK.isFinishing()) {
            this.geK.finish();
        }
    }
}
