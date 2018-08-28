package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.3;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandTBSDownloadProxyUI$3$1 implements Runnable {
    final /* synthetic */ 3 gwt;

    AppBrandTBSDownloadProxyUI$3$1(3 3) {
        this.gwt = 3;
    }

    public final void run() {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
        AppBrandTBSDownloadProxyUI.a(this.gwt.gws);
    }
}
