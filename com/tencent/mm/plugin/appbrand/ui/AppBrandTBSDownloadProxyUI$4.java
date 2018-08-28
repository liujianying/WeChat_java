package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;

class AppBrandTBSDownloadProxyUI$4 implements Runnable {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    AppBrandTBSDownloadProxyUI$4(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    public final void run() {
        AppBrandTBSDownloadProxyUI.anB();
        this.gws.setResult(0, new Intent());
        this.gws.finish();
    }
}
