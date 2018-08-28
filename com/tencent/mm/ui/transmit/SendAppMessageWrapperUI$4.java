package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SendAppMessageWrapperUI$4 implements a {
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$4(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.uEK = sendAppMessageWrapperUI;
    }

    public final void a(boolean z, String str, int i) {
        this.uEK.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
        this.uEK.finish();
    }
}
