package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.f.a;

class AppBrandTBSDownloadProxyUI$3 implements a {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    AppBrandTBSDownloadProxyUI$3(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    public final void onNeedDownloadFinish(boolean z, int i) {
        if (!z || i < 36824) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
            this.gws.setResult(0, new Intent());
            this.gws.finish();
            return;
        }
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        ah.A(new 1(this));
    }
}
