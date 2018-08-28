package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class AppBrandLaunchProxyUI$1 implements OnCancelListener {
    final /* synthetic */ AppBrandLaunchProxyUI geK;

    AppBrandLaunchProxyUI$1(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        this.geK = appBrandLaunchProxyUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.geK.finish();
    }
}
