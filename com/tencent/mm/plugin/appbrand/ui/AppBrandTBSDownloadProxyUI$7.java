package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandTBSDownloadProxyUI$7 implements OnClickListener {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    AppBrandTBSDownloadProxyUI$7(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.a(366, 3, 1, false);
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
        a.kB(false);
        this.gws.setResult(2, new Intent());
        this.gws.finish();
    }
}
