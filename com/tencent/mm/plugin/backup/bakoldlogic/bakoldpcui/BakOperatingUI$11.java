package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class BakOperatingUI$11 implements Runnable {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$11(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final void run() {
        Intent intent = new Intent(this.haO, BakFinishUI.class);
        intent.putExtra("cmd", BakOperatingUI.j(this.haO));
        MMWizardActivity.D(this.haO, intent);
    }
}
