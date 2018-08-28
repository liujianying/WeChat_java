package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$d;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

class WebViewUI$54 implements h$d {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$54(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                Bundle bundle = new Bundle();
                bundle.putLong("fav_local_id", this.pZJ.getIntent().getLongExtra("fav_local_id", -1));
                try {
                    if (this.pZJ.gcO.T(bundle)) {
                        x.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
                        this.pZJ.pQY.u("mm_del_fav", Boolean.valueOf(true));
                        this.pZJ.finish();
                        return;
                    }
                    x.w("MicroMsg.WebViewUI", "try to del web url fail");
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    x.e("MicroMsg.WebViewUI", "try to del web url crash");
                    return;
                }
            default:
                x.i("MicroMsg.WebViewUI", "do del cancel");
                return;
        }
    }
}
