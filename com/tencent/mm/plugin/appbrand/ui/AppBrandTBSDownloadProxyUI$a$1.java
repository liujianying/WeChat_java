package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a;

class AppBrandTBSDownloadProxyUI$a$1 implements Runnable {
    final /* synthetic */ int dsV;
    final /* synthetic */ a gwv;

    AppBrandTBSDownloadProxyUI$a$1(a aVar, int i) {
        this.gwv = aVar;
        this.dsV = i;
    }

    public final void run() {
        this.gwv.gws.tipDialog.setMessage(this.gwv.gws.mController.tml.getString(j.app_brand_x5_installing_tips, new Object[]{String.valueOf(this.dsV)}));
    }
}
