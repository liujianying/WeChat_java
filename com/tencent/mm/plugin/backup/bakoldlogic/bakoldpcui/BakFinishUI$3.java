package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

class BakFinishUI$3 implements Runnable {
    final /* synthetic */ BakFinishUI haF;

    BakFinishUI$3(BakFinishUI bakFinishUI) {
        this.haF = bakFinishUI;
    }

    public final void run() {
        x.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
        MMWizardActivity.D(this.haF, new Intent(this.haF, BakConnErrorUI.class));
    }
}
