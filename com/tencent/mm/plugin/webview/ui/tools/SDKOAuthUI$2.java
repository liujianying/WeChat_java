package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$2 implements b {
    final /* synthetic */ SDKOAuthUI pWs;
    final /* synthetic */ bit pWt;

    SDKOAuthUI$2(SDKOAuthUI sDKOAuthUI, bit bit) {
        this.pWs = sDKOAuthUI;
        this.pWt = bit;
    }

    public final void hj(int i) {
        x.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            SDKOAuthUI.a(this.pWs);
        } else {
            SDKOAuthUI.a(this.pWs, this.pWt.rqU);
        }
    }
}
