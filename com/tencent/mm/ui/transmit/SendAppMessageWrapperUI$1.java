package com.tencent.mm.ui.transmit;

import com.tencent.mm.sdk.platformtools.al.a;

class SendAppMessageWrapperUI$1 implements a {
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$1(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.uEK = sendAppMessageWrapperUI;
    }

    public final boolean vD() {
        if (this.uEK.getWindow() != null && this.uEK.getWindow().getDecorView() != null && this.uEK.getWindow().getDecorView().getWindowToken() != null) {
            SendAppMessageWrapperUI.c(this.uEK);
            return false;
        } else if (SendAppMessageWrapperUI.a(this.uEK) >= 10) {
            return false;
        } else {
            SendAppMessageWrapperUI.b(this.uEK);
            return true;
        }
    }
}
