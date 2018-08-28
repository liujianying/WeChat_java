package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.3;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$3$1 implements b {
    final /* synthetic */ 3 pWu;

    SDKOAuthUI$3$1(3 3) {
        this.pWu = 3;
    }

    public final void hj(int i) {
        x.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i));
        if (i == 1) {
            SDKOAuthUI.a(this.pWu.pWs);
        } else if (this.pWu.pWt.rZN) {
            SDKOAuthUI.a(this.pWu.pWs, SDKOAuthUI.b(this.pWu.pWs), SDKOAuthUI.c(this.pWu.pWs).state, SDKOAuthUI.Rk(SDKOAuthUI.b(this.pWu.pWs)), SDKOAuthUI.d(this.pWu.pWs).bVO());
        } else {
            SDKOAuthUI.a(this.pWu.pWs, this.pWu.pWt.rqU);
        }
    }
}
