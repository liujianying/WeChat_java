package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandProcessProxyUI$3 implements OnKeyListener {
    final /* synthetic */ String fEb;
    final /* synthetic */ AppBrandProcessProxyUI fEc;

    AppBrandProcessProxyUI$3(AppBrandProcessProxyUI appBrandProcessProxyUI, String str) {
        this.fEc = appBrandProcessProxyUI;
        this.fEb = str;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            if (!bi.oW(this.fEb)) {
                AppBrandProcessProxyUI.b(this.fEc).onClick(AppBrandProcessProxyUI.a(this.fEc), -3);
                dialogInterface.dismiss();
            }
            this.fEc.a(null);
        }
        return false;
    }
}
