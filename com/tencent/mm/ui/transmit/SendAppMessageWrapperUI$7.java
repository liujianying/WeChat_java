package com.tencent.mm.ui.transmit;

import com.tencent.mm.pluginsdk.model.j.a;

class SendAppMessageWrapperUI$7 implements a {
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$7(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.uEK = sendAppMessageWrapperUI;
    }

    public final void cbw() {
        if (SendAppMessageWrapperUI.f(this.uEK) != null) {
            SendAppMessageWrapperUI.f(this.uEK).dismiss();
            SendAppMessageWrapperUI.g(this.uEK);
        }
    }
}
