package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$3 implements OnClickListener {
    final /* synthetic */ SDKOAuthUI pWs;
    final /* synthetic */ bit pWt;

    SDKOAuthUI$3(SDKOAuthUI sDKOAuthUI, bit bit) {
        this.pWs = sDKOAuthUI;
        this.pWt = bit;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        c.a(this.pWs, a.dEd, SDKOAuthUI.b(this.pWs), new 1(this));
    }
}
