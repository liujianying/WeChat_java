package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class OAuthUI$7 implements a {
    final /* synthetic */ OAuthUI pVZ;

    OAuthUI$7(OAuthUI oAuthUI) {
        this.pVZ = oAuthUI;
    }

    public final void a(c cVar, String str, boolean z) {
        x.i("MicroMsg.OAuthUI", "onResult, url = " + str + ", isShowLocalErrorPage = " + z);
        if (cVar != null) {
            cVar.pVQ = false;
        }
        if (z) {
            String string;
            try {
                string = this.pVZ.getString(R.l.oauth_network_error_doc);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OAuthUI", e, "", new Object[0]);
                string = null;
            }
            x.i("MicroMsg.OAuthUI", "onResult, html = " + string);
            if (this.pVZ.mhH != null) {
                this.pVZ.mhH.loadUrl(string);
                if (this.pVZ.pQY != null) {
                    this.pVZ.pQY.bUv().cbP = string;
                }
            }
        } else if (!bi.oW(str) && this.pVZ.mhH != null) {
            this.pVZ.mhH.loadUrl(str);
            if (this.pVZ.pQY != null) {
                this.pVZ.pQY.bUv().cbP = str;
            }
        }
    }

    public final void c(boolean z, String str, String str2, String str3) {
        if (z) {
            OAuthUI.a(this.pVZ, str2, str3, str);
        } else {
            OAuthUI.b(this.pVZ, str3);
        }
    }
}
