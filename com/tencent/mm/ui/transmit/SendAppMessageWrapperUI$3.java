package com.tencent.mm.ui.transmit;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SendAppMessageWrapperUI$3 implements a {
    final /* synthetic */ WXMediaMessage bAi;
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$3(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage) {
        this.uEK = sendAppMessageWrapperUI;
        this.bAi = wXMediaMessage;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            SendAppMessageWrapperUI.a(this.uEK, this.bAi, str, i);
        } else {
            SendAppMessageWrapperUI.d(this.uEK);
        }
    }
}
