package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandTBSDownloadProxyUI$5 implements OnCancelListener {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    AppBrandTBSDownloadProxyUI$5(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
        this.gws.setResult(2, new Intent());
        this.gws.finish();
    }
}
