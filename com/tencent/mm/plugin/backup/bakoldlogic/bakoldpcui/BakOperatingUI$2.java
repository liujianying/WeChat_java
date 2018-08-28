package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

class BakOperatingUI$2 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$2(BakOperatingUI bakOperatingUI, int i) {
        this.haO = bakOperatingUI;
        this.bFq = i;
    }

    public final void run() {
        x.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", new Object[]{Integer.valueOf(this.bFq)});
        if (this.bFq == 15) {
            BakOperatingUI.n(this.haO);
            return;
        }
        MMWizardActivity.D(this.haO, new Intent(this.haO, BakConnErrorUI.class));
    }
}
