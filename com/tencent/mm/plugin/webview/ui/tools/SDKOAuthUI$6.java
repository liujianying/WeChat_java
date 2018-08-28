package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$6 implements a {
    final /* synthetic */ SDKOAuthUI pWs;

    SDKOAuthUI$6(SDKOAuthUI sDKOAuthUI) {
        this.pWs = sDKOAuthUI;
    }

    public final boolean vD() {
        if (this.pWs.isFinishing()) {
            x.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
        } else {
            SDKOAuthUI.e(this.pWs);
        }
        return false;
    }
}
