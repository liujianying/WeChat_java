package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.pluginsdk.ui.tools.k;

class AppBrandTBSDownloadProxyUI$6 implements OnClickListener {
    final /* synthetic */ AppBrandTBSDownloadProxyUI gws;

    AppBrandTBSDownloadProxyUI$6(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.gws = appBrandTBSDownloadProxyUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.a(366, 2, 1, false);
        a.kB(false);
        k.kB(2);
        if (!this.gws.isFinishing() && !this.gws.tlP) {
            AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = this.gws;
            Context context = this.gws.mController.tml;
            this.gws.mController.tml.getString(j.app_tip);
            appBrandTBSDownloadProxyUI.tipDialog = com.tencent.mm.ui.base.h.a(context, this.gws.mController.tml.getString(j.app_brand_x5_installing_simple_tips), true, null);
            this.gws.tipDialog.setOnCancelListener(new 1(this));
            AppBrandTBSDownloadProxyUI.b(this.gws);
            AppBrandTBSDownloadProxyUI.c(this.gws);
        }
    }
}
